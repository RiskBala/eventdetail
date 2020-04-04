package com.online.event.detail.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.online.event.detail.model.Registration;

public interface RegistraionRepository extends MongoRepository<Registration, String> {
	List<Registration> findByEventIdAndAssociateId(String eventId, String associateId);
}
