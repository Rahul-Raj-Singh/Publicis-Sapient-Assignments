package com.IOC.Learn;

public class Mobile {
	
	private Screen sc;
	private Speaker sp;
	private Camera cam;
	
	public void setSc(Screen sc) {
		this.sc = sc;
	}
	
	public void setSp(Speaker sp) {
		this.sp = sp;
	}
	
	public void setCam(Camera cam) {
		this.cam = cam;
	}
	
	public void displayConfig() {
		sc.displayConfig();
		sp.displayConfig();
		cam.displayConfig();
	}
	
}
