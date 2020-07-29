package com.learn.springbootdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learn.springbootdemo.entity.Meeting;
import com.learn.springbootdemo.entity.Participant;

@RestController
public class RestApp {

	private List<Meeting> meetings;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostConstruct
	public void setup() {
		meetings = new ArrayList<>();
		meetings.add(new Meeting(152, "Microservices", "13:00", "15:00"));
		meetings.add(new Meeting(201, "Spring Framework", "14:00", "16:00"));
		meetings.add(new Meeting(423, "MySQL", "13:45", "15:00"));
		meetings.add(new Meeting(100, "JAVA", "13:00", "15:30"));
		meetings.add(new Meeting(265, "Mongo DB", "15:00", "16:00"));
	}

	@GetMapping("/meeting")
	public List<Meeting> getMeetings() {

		return meetings;
	}

	@GetMapping("/meeting/{id}")
	public Meeting getMeeting(@PathVariable Integer id) {
		
		Meeting meeting = findMeeting(id);
		
		System.out.println(meeting + " " + id);
		
		return meeting;
	}
	
	@GetMapping("/meeting/{meetingId}/participants")
	public List<Participant> findMeetin(@PathVariable Integer meetingId) {
		
		String participantURL = "http://localhost:8080/participant/meeting/" +  meetingId;
		ResponseEntity<List<Participant>> response = restTemplate
				.exchange(participantURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Participant>>() {});
		
		return response.getBody();
	}

	public Meeting findMeeting(Integer meetingId) {
				
		for (Meeting i : meetings) {
			if (i.getMeetingId().equals(meetingId)) 
				return i;
		}

		return null;
	}

}
