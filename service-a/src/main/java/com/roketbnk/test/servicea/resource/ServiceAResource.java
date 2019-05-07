package com.roketbnk.test.servicea.resource;

import com.roketbnk.test.servicea.entity.ServiceAMessage;
import com.roketbnk.test.servicea.entity.ServiceBResponse;
import com.roketbnk.test.servicea.repository.ServiceARepository;
import com.roketbnk.test.servicea.service.ServiceBComponent;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static java.lang.Thread.currentThread;

@RequestMapping("/servicea/api/")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ServiceAResource {

    private final ServiceARepository serviceARepository;

    private final ServiceBComponent serviceBComponent;

    @PostMapping(value = "/{id}")
    public ServiceAMessage findOwner(@ApiParam @PathVariable("id") Integer value) {
        ServiceBResponse serviceBReponse = serviceBComponent.sendMessageToServiceB(currentThread().getName());
        ServiceAMessage entity = new ServiceAMessage();
        entity.setDateTime(LocalDateTime.now());
        entity.setMessage(serviceBReponse.getMessage());
        entity.setServiceBid(serviceBReponse.getId());
        entity.setValue(value);
        serviceARepository.save(entity);
        return entity;
    }
}
