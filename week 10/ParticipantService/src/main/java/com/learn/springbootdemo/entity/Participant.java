package com.learn.springbootdemo.entity;

public class Participant {
	private String pname;
	private Integer pid;
	private Integer meetingId;

	public Participant(String pname, Integer pid, Integer meetingId) {
		this.pname = pname;
		this.pid = pid;
		this.meetingId = meetingId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

}
