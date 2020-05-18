package com.IOC.Learn;

public class Speaker {
	
	private int volLevel;
	private String speakerType;
	

	public void setVolLevel(int volLevel) {
		this.volLevel = volLevel;
	}


	public void setSpeakerType(String speakerType) {
		this.speakerType = speakerType;
	}


	public void displayConfig() {
		System.out.println(String.format("Speaker volLevel = %d, type = %s", this.volLevel, this.speakerType));
	}

}
