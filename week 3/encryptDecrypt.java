package com.Learning;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		
		int[] a = new int[26];
		int c = 0, num = 0;
		
		// Populate array a with first 26 prime nos.
		while(c<26) {
			if(isPrime(++num)) 
				a[c++] = num; 
		}
		
		// User Input for encrypting
		Scanner in =new Scanner(System.in);
		String s = in.nextLine();
		
		//Encrypting and printing
		for(int i=0; i<s.length(); i++)
			System.out.print(String.format("%X ", a[s.charAt(i)-65]));
		System.out.println();
		
		// User Input for Decrypting
		in = new Scanner(System.in);
		s = in.nextLine();
		in.close();
		
		//Decrypting and printing
		for(String i: s.split(" ")) 
			System.out.print((char)(search(a, Integer.valueOf(i, 16).intValue()) + 65));
		
		System.exit(0);
		
	}
	
	public static boolean isPrime(int n) {

		for(int i=2; i<=(int)Math.sqrt(n); i++) {
			if(n%i == 0)
				return false;
		}
		
		return true;
	}
	
	public static int search(int[] a, int key) {
		for(int i=0; i<26; i++) {
			if(a[i] == key)
				return i;
		}
		return -1;
	}

}
