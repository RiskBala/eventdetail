package com.online.event.detail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.event.detail.model.Event;
import com.online.event.detail.model.Registration;
import com.online.event.detail.repository.EventDetailRepository;
import com.online.event.detail.repository.RegistraionRepository;


@Service
public class EventDetailService {

	@Autowired
	private EventDetailRepository eventDetailRepository;
	
	@Autowired
	private RegistraionRepository registraionRepository;

	enum Roles {
		VOLUNTEER, ADMIN
	}

	public List<Event> getEvents(String eventStatus, String roles) {
		if(roles.equalsIgnoreCase("Admin")) {
			return eventDetailRepository.findAll();
		} else {
			return eventDetailRepository.findByStatus(eventStatus);
		}
	}
	
	public String register(String eventId, String userId) {
		List<Registration> reg =registraionRepository.findByEventIdAndAssociateId(eventId, userId);
		if (reg != null && reg.size()>0 ) {
			return "You have already volunteered for this event";
		} else {
			Registration registration = new Registration();
			registration.setEventId(eventId);
			registration.setAssociateId(userId);
			registration = registraionRepository.save(registration);
			return "Your registration ID is " + registration.getId();
		}
	}
	
}