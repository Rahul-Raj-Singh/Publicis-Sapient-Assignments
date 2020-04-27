package com.Learning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Synonym {
	public static void main(String[] args) {
		
		//Map to hold key:sorted(values)
		HashMap<String, TreeSet<String>> map = new HashMap<String, TreeSet<String>>();
		
		//Two default enteries
		map.put("GoodMorning", new TreeSet<String>(Arrays.asList("GoodMorning", "Shubhodaya", "Shubhohday", "Bonjour")));
		map.put("GoodEvening", new TreeSet<String>(Arrays.asList("good Evening", "Shubha sange", "susandhya", "Bonsoir")));
		
		// Start reading inputs
		Scanner in=new Scanner(System.in);
		System.out.println("Enter text to proceed..");
		String s = in.nextLine();
		
		while(true) {									// Accept continuous inputs until user presses "N"
			
			if(map.containsKey(s))						// Check if key is present in map
				System.out.println(map.get(s));
			else {
				System.out.println("Value not present in Map\nDo you wish to add (Y/N)");
				String key = s;
				s = in.nextLine();
				if(s.equalsIgnoreCase("Y")) 
					addToMap(map, in, key);				// Custom method to add new entry in map
				else
					break;								// User wishes to terminate
			}
			
			System.out.println("Enter text to proceed..");
			s = in.nextLine();							// Accept next input
		}
		
		System.out.println("Fin...");
		 	
	}
	
	public static void addToMap(HashMap<String, TreeSet<String>> map, Scanner in, String key) {
		
		System.out.println("Enter synonyms: ");
		String s = in.nextLine();
		TreeSet<String> ts =new TreeSet<String>();

		while(!s.isEmpty()) {						// Accept synonyms until user enters empty string
			ts.add(s);
			s = in.nextLine();
		}
			
		map.put(key, ts);
		System.out.println("Map Updated.");
	}

}
