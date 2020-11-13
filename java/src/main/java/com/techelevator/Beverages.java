package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends Items {

	public Beverages(String name, BigDecimal price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	
	public String getSound() {
		return "Glug Glug, Yum!";
	}

}
