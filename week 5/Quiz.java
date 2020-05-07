package com.Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		
	Scanner in=new Scanner(System.in);
	String ans;
	Question q=new Question();							 	// Question Bank object
	Control c = new Control();                           	// Control object is used to share variable between threads, here 'check' is shared
	CustomThread t=new CustomThread(c);						// This thread runs background timer
	
	t.setDaemon(true);									 	// CustomThread made Daemon
	t.start();
	
	// Question 1
	q.askQuestion();
	c.check = false;                                    	// check is set false and timer is started
	ans = in.next();
	c.check = true;											// check is set true only when user has entered some answer, it also stops the timer
	
	if(!q.getAns().equalsIgnoreCase(ans)) {					// Wrong answer terminates the program
		System.out.println("Sorry Wrong Answer :(");
		System.exit(0);
	}
	
	while(!q.isEmpty()) {									// Keep asking questions until question bank is exhausted
	
		q.askQuestion();
		c.check = false;
		ans = in.next();
		c.check = true;
		
		if(!q.getAns().equalsIgnoreCase(ans)) {             
			System.out.println("Sorry Wrong Answer :(");
			System.exit(0);
		}
		
	}
	
	System.out.println("Congrats!!! You Won");				// All questions successfully answered
	
		
	}
	
 
}

class CustomThread extends Thread{
	
	private Control c;                                    						// Shared Control object
	
	CustomThread(Control c){
		this.c = c;
	}
	
	public void run() {                                 						// Method will run indefinitely until timer runs out or wrong question is answered
		while(true) {
			if(!c.check) {
				
				long start = System.currentTimeMillis();
				while(!c.check && System.currentTimeMillis() <= start+10000);    // 10s wait or user enters some answer
				
				if(!c.check) {													 // User took longer than 10s and thus program terminates
					System.out.println("Times Up!!!");
					System.exit(0);
				}
			}
		}
	}
}

class Control{
	public volatile boolean check;                                       		// check variable is set volatile to make assignment atomic
}

class Question{																	// Question class to askQuestion and getAnswer
	private ArrayList<String> ques = new ArrayList<>(Arrays.asList(
			"Who won WWE Royal Rumble 2020?\na.Drew Mcntyre  b.Brock Lesnar  c.Randy Orton   d.Kofi Kingston",
			"Who is the President of the USA?\na.Ramnath Kovind  b.Donald Trump  c.Henry Clinton  d.Barack Obama",
			"Which of the folllowing is not shared by thread?\na.Heap  b.Process Id  c.SCP  d.Stack",
			"JavaScript internally uses classes?\na.Yes  b.No",
			"Which is Checked Exception?\na.NullPointerException  b.FileNotFoundException  c.StackOverflowError  d.ArithmeticException"));
	private ArrayList<String> ans = new ArrayList<>(Arrays.asList("a", "b", "d", "b", "b"));
    static int index = -1;
    
	public void askQuestion() {
		System.out.println(ques.get(++index));
	}
	
	public String getAns() {
		return ans.get(index);
	}
	
	public boolean isEmpty() {													// Total 5 Questions in bank
		return index == 4;
	}
	
}

