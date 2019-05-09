package com.roketbnk.test.apigateway.security.adapter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(serviceId = "uaa-service", path = "/uaa")
public interface UaaComponent {
    @RequestMapping(method = RequestMethod.POST, path = "/login")
    List<String> auth(@RequestParam("username") String username, @RequestParam(name = "password") String password);

}
