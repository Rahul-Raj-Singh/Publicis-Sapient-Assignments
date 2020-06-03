package com.dispatcher;

public class Product {
	
	private int prodId;
	private String name;
	
	public Product(int prodId, String name) {
		super();
		this.prodId = prodId;
		this.name = name;
	}

	public int getprodId() {
		return prodId;
	}

	public String getName() {
		return name;
	}
}
