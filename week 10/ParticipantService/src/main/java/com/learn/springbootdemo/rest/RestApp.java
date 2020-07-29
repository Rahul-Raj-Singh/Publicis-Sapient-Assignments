package com.learn.springbootdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springbootdemo.entity.Participant;

@RestController
public class RestApp {

	List<Participant> participants;

	@PostConstruct
	public void setup() {
		participants = new ArrayList<>();
		participants.add(new Participant("Shane", 51, 201));
		participants.add(new Participant("Jake", 11, 201));
		participants.add(new Participant("Ann", 45, 100));
		participants.add(new Participant("Brad", 2, 152));
		participants.add(new Participant("Waugh", 43, 423));
		participants.add(new Participant("Shane", 12, 265));

	}

	@GetMapping("/participant")
	public List<Participant> getParticipants() {
		return participants;
	}

	@GetMapping("/participant/{participantId}")
	public Participant getParticipant(@PathVariable Integer participantId) {

		Participant participant = findParticipant(participantId);

		System.out.println(participant + " " + participantId);

		return participant;
	}
	
	@GetMapping("/participant/meeting/{meetingId}")
	public List<Participant> getParti(@PathVariable Integer meetingId) {

		return findParticipantWithMeetingId(meetingId);
	}

	// Utility Methods
	private Participant findParticipant(Integer id) {

		for (Participant i : participants) {
			if (i.getPid().equals(id))
				return i;
		}

		return null;
	}
	
	private List<Participant> findParticipantWithMeetingId(Integer meetingId){
		
		List<Participant> ans = new ArrayList<>();
		
		for (Participant i : participants) {
			if (i.getMeetingId().equals(meetingId))
				ans.add(i);
		}		
		
		return ans;
	}
	
	

}
