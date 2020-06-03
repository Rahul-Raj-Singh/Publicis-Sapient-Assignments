package com.dispatcher;

import java.util.Arrays;
import java.util.List;

public class EmployeeUtil {
	
	public List<Employee> getEmployees() {
		return Arrays.asList(new Employee("Brad Law", "SDE", 142), new Employee("Stacy Cage", "HR", 21),
				new Employee("Wayne", "CEO", 1));
	}
}

