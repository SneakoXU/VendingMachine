package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Items{

	public Chips(String name, BigDecimal price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	
	public String getSound() {
		return "Crunch Crunch, Yum!";
	}


}
