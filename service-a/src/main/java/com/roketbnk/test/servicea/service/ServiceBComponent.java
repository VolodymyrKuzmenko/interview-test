package com.roketbnk.test.servicea.service;

import com.roketbnk.test.servicea.entity.ServiceBResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(serviceId = "service-b", path = "/serviceb/api")
public interface ServiceBComponent {
    @RequestMapping(method = RequestMethod.POST, path = "/send")
    ServiceBResponse sendMessageToServiceB(@RequestBody String message);

}
