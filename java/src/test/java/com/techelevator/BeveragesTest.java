package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class BeveragesTest {
	
	@Test
	public void get_sound_test() {
		Beverages beveragesTest = new Beverages("test", new BigDecimal("1.00"));
		String expectedString = "Glug Glug, Yum!";
		Assert.assertEquals(expectedString, beveragesTest.getSound());
				
	}
	
	@Test
	public void beverage_purchase_test() {
		Beverages beveragesTest = new Beverages("Cola", new BigDecimal("1.25"));
		beveragesTest.purchaseItem();
		Assert.assertEquals(4, beveragesTest.getNumberOfItems());
	}
	
	@Test
	public void cola_is_available_to_purchase_test() {
		Beverages beveragesTest = new Beverages("Cola", new BigDecimal("1.25"));
		Assert.assertEquals(true, beveragesTest.isAvailableToPurchase());
	}
	
	@Test
	public void heavy_is_available_to_purchase_test() {
		Beverages beveragesTest = new Beverages("Heavy", new BigDecimal("1.50"));
		Assert.assertEquals(true, beveragesTest.isAvailableToPurchase());
	}
	
	@Test
	public void not_available_to_purchase_test() {
		Beverages beveragesTest = new Beverages("Cola", new BigDecimal("1.25"));
		for(int i = 1; i<6; i++) {
			beveragesTest.purchaseItem();
		}
		Assert.assertEquals(false, beveragesTest.isAvailableToPurchase());
	}
	
	@Test
	public void c2_not_available_to_purchase_test() {
		Beverages beveragesTest = new Beverages("Dr. Salt", new BigDecimal("1.50"));
		for(int i = 1; i<6; i++) {
			beveragesTest.purchaseItem();
		}
		Assert.assertEquals(false, beveragesTest.isAvailableToPurchase());
	}
	
	@Test
	public void get_price_test() {
		Beverages beveragesTest = new Beverages("Cola", new BigDecimal("1.25"));
		BigDecimal expected = new BigDecimal("1.25");
		Assert.assertEquals(1.25, beveragesTest.getPrice());
	}
	

}
