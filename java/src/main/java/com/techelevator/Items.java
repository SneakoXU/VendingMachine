package com.techelevator;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class Items {

	private String name;
	private BigDecimal price = new BigDecimal("0.00");
	private int numberOfItems = 5;
	
	public Items (String name, BigDecimal price) { 
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	public boolean isAvailableToPurchase() {
		if(this.numberOfItems >=1) {
			return true;
		}else {
			System.out.println("\n**********Item is SOLD OUT.**********\n\n");
			return false;
		}
		
	}
	public void purchaseItem() {
		numberOfItems -= 1;
	}
	
	public abstract String getSound();
	
	public String toString() {
		//might need to remove moneyformat and change string to bigdecimal
		DecimalFormat moneyFormat = new DecimalFormat("#.00");
		String string= String.format(" %1$-20s %2$-10s %3$s", name, "$" + price, this.getNumberOfItems());
		return string;
	}
	

}
