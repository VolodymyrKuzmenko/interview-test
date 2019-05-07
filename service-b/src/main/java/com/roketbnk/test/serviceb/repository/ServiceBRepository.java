package com.roketbnk.test.serviceb.repository;

import com.roketbnk.test.serviceb.entity.ServiceBMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBRepository extends CrudRepository<ServiceBMessage, Long> {
}
