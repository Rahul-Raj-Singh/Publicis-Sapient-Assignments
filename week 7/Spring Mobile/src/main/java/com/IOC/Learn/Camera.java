package com.IOC.Learn;

public class Camera {
	
	private int pixels;
	

	public void setPixels(int pixels) {
		this.pixels = pixels;
	}


	public void displayConfig() {
		System.out.println(String.format("Camera pixels = %d MP", this.pixels));
	}
	
	
}
