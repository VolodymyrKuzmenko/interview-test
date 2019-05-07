package com.roketbnk.test.servicea.repository;

import com.roketbnk.test.servicea.entity.ServiceAMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceARepository extends MongoRepository<ServiceAMessage, String> {
}
