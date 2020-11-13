package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Items{

	public Candy(String name, BigDecimal price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	
	public String getSound() {
		return "Munch Munch, Yum!";
	}

}
