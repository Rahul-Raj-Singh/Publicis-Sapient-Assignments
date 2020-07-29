package com.learn.springbootdemo.entity;

public class Meeting {

	private Integer meetingId;
	private String topic;
	private String startTime;
	private String endTime;

	public Meeting() {

	}

	public Meeting(Integer meetingId, String topic, String startTime, String endTime) {
		this.meetingId = meetingId;
		this.topic = topic;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
