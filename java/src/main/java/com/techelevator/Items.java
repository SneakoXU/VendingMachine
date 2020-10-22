package com.techelevator;

import java.text.DecimalFormat;

public abstract class Items {

	private String name;
	private double price;
	private int numberOfItems = 5;
	
	public Items (String name, double price) { 
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
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
		DecimalFormat moneyFormat = new DecimalFormat("#.00");
		String string= String.format(" %1$-20s %2$-10s %3$s", name, "$" + moneyFormat.format(price), this.getNumberOfItems());
		return string;
	}
	

}
