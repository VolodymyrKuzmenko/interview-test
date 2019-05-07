package com.roketbnk.test.serviceb.resource;

import com.roketbnk.test.serviceb.entity.ServiceBMessage;
import com.roketbnk.test.serviceb.repository.ServiceBRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/serviceb/api/")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ServiceBResource {

    private final ServiceBRepository repository;

    @PostMapping(value = "/send")
    public ServiceBMessage findOwner(@RequestBody String message) {
        ServiceBMessage entity = new ServiceBMessage();
        entity.setMessage(message);
        repository.save(entity);
        return entity;
    }
}
