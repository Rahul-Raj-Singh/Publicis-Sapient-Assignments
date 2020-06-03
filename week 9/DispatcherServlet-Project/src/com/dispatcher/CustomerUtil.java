package com.dispatcher;

import java.util.Arrays;
import java.util.List;

public class CustomerUtil {
	
	public List<Customer> getCustomers(){
		return Arrays.asList(new Customer("Intel"), new Customer("AMD"), 
				new Customer("ESL Gaming"), new Customer("Gamestop"));
	}
}
