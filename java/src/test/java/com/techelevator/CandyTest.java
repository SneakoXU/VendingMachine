package com.techelevator;
import org.junit.Assert;
import org.junit.Test;

import com.techelevator.Candy;

public class CandyTest {
	@Test
	public void get_sound_test() {
		Candy candyTest = new Candy("test", 1.00);
		String expectedString = "Munch Munch, Yum!";
		Assert.assertEquals(expectedString, candyTest.getSound());
				
	}
	@Test
	public void candy_purchase_test() {
		Candy candyTest = new Candy("Cowtales", 1.50);
		candyTest.purchaseItem();
		Assert.assertEquals(4, candyTest.getNumberOfItems());
	}
	
	@Test
	public void is_available_to_purchase_test() {
		Candy candyTest = new Candy("Cowtales", 1.50);
		Assert.assertEquals(true, candyTest.isAvailableToPurchase());
	}
	
	@Test
	public void not_available_to_purchase_test() {
		Candy candyTest = new Candy("Cowtales", 1.50);
		for(int i = 1; i<6; i++) {
			candyTest.purchaseItem();
		}
		Assert.assertEquals(false, candyTest.isAvailableToPurchase());
	}
	
	@Test
	public void get_price_test() {
		Candy candyTest = new Candy("Cowtales", 1.50);
		Assert.assertEquals(1.50, candyTest.getPrice(), 1e-15);
	}

}
