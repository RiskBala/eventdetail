package com.online.event.detail.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.online.event.detail.model.Event;


public interface EventDetailRepository extends MongoRepository<Event, String> {

	List<Event> findByStatus(String eventStatus);

	List<Event> findAll();
	
}