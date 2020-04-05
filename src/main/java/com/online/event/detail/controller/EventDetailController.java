package com.online.event.detail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.event.detail.model.Event;
import com.online.event.detail.service.EventDetailService;

@Controller
@CrossOrigin(origins = "http://outreach-ui-s2-travelsystem.apps.na311.openshift.opentlc.com")
public class EventDetailController {
	@Autowired
	private EventDetailService eventDetailService;

	@RequestMapping(value = "events/v1/{eventStatus}", method = RequestMethod.OPTIONS)
	@ResponseBody
	public List<Event> getEvents(@PathVariable String eventStatus,
			@RequestHeader(value = "userId", required = true) String userId,
			@RequestHeader(value = "roles", required = true) String roles) {
		return eventDetailService.getEvents(eventStatus, roles);
	}
	@RequestMapping(value = "events/eventStatus", method = RequestMethod.GET)
	@ResponseBody
	public List<Event> getEvents(@RequestHeader(value = "userId", required = true) String userId,
			@RequestHeader(value = "roles", required = true) String roles) {
		return eventDetailService.getEvents("open", roles);
	}
	
	@RequestMapping(value = "registration/v1/{eventId}", method = RequestMethod.POST)
	@ResponseBody
	public String register(@PathVariable String eventId, @RequestHeader(value = "userId", required = true) String userId,
			@RequestHeader(value = "roles", required = true) String roles) {
		return eventDetailService.register(eventId, userId);
	}
}
