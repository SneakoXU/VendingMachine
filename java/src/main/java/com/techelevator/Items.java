package com.techelevator;

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

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	public boolean isAvailableToPurchase() {
		if(this.numberOfItems >=1) {
			return true;
		}else {
			System.out.println("Item is SOLD OUT.");
			return false;
		}
		
	}
	public void purchaseItem() {
		numberOfItems -= 1;
	}
	
	public abstract String getSound();

	

}
