package com.roketbnk.test.servicea.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class ServiceAMessage {
    @Id
    private String serviceAid;
    private LocalDateTime dateTime;
    private Long serviceBid;
    private String message;
    private Integer value;
}
