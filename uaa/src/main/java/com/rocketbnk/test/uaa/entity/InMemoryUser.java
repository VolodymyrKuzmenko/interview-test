package com.rocketbnk.test.uaa.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class InMemoryUser {
    private String username;
    private String password;
    private List<String> roles;
}
