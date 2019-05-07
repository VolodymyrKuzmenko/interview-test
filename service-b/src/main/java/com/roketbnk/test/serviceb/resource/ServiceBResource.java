package com.roketbnk.test.serviceb.resource;

import com.roketbnk.test.serviceb.entity.ServiceBMessage;
import com.roketbnk.test.serviceb.repository.ServiceBRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/serviceb/api/")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ServiceBResource {

    private final ServiceBRepository repository;

    @GetMapping(value = "/{message}")
    public ServiceBMessage findOwner(@PathVariable("message") String message) {
        ServiceBMessage entity = new ServiceBMessage();
        entity.setMessage(message);
        repository.save(entity);
        return entity;
    }
}
