package com.rocketbnk.test.uaa.controller;

import com.rocketbnk.test.uaa.entity.InMemoryUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static java.util.Collections.singletonList;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UaaController {

    private final Map<String, InMemoryUser> userMap = of("user", new InMemoryUser().setUsername("user")
                                                                                   .setRoles(singletonList("user"))
                                                                                   .setPassword("password"), "admin",
                                                         new InMemoryUser().setUsername("admin")
                                                                           .setRoles(Arrays.asList("admin", "user"))
                                                                           .setPassword("admin"));

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public List<String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        InMemoryUser user = userMap.get(username);
        log.info("User with username {} tyring to login.", username);
        if (user != null && StringUtils.equals(user.getPassword(), password)) {
            log.info("User with username {} logged in.", username);
            return user.getRoles();
        } else {
            return Collections.emptyList();
        }
    }

}
