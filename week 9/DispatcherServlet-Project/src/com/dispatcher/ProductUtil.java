package com.dispatcher;

import java.util.Arrays;
import java.util.List;

public class ProductUtil {
	
	public List<Product> getProducts(){
		return Arrays.asList(new Product(3, "Monitors"), new Product(7, "Gaming Mouse"),
							new Product(10, "Headphones"), new Product(12, "Web cameras")
				);
	}
}
