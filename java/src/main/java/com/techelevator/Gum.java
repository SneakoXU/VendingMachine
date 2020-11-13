package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Items{

	public Gum(String name, BigDecimal price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	public String getSound() {
		return "Chew Chew, Yum!";
	}


}
