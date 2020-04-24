package com.Learning;

public class Runner {
	
	public static void alpha2Num(String s) {
		for(int i=0; i<s.length(); i++) {
			System.out.print(String.format("%x", s.charAt(i)-97));
		}
		System.out.println();
	}
	
	public static void num2Alpha(String ans) {
		for(String i: ans.split(" ")) {
			System.out.print((char)(Integer.valueOf(i, 16)+97));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		alpha2Num("abk");        //01a
		num2Alpha("0 1 a");		 //abk
	}

}