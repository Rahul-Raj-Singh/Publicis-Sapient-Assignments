package com.IOC.Learn;

public class Screen {
	
	private double length, bezel;
	
	public void setLength(double length) {
		this.length = length;
	}

	public void setBezel(double bezel) {
		this.bezel = bezel;
	}

	public void displayConfig() {
		System.out.println(String.format("Screen Length = %1.2f inches, Bezel = %1.2f inches", this.length, this.bezel));
	}
}
