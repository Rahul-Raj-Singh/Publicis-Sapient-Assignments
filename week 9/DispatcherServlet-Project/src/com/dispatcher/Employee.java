package com.dispatcher;

public class Employee{
	
	private String name, role;
	private int empId;
	
	public Employee(String name, String role, int empId) {
		super();
		this.name = name;
		this.role = role;
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public int getEmpId() {
		return empId;
	}
	
	

}