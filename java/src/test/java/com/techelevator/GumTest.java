package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {
	@Test
	public void get_sound_test() {
		Gum gumTest = new Gum("test", new BigDecimal("1.00"));
		String expectedString = "Chew Chew, Yum!";
		Assert.assertEquals(expectedString, gumTest.getSound());
				
	}
	@Test
	public void gum_purchase_test() {
		Gum gumTest = new Gum("U-Chews", new BigDecimal("0.85"));
		gumTest.purchaseItem();
		Assert.assertEquals(4, gumTest.getNumberOfItems());
	}
	
	@Test
	public void is_available_to_purchase_test() {
		Gum gumTest = new Gum("U-Chews", new BigDecimal("0.85"));
		Assert.assertEquals(true, gumTest.isAvailableToPurchase());
	}
	
	@Test
	public void not_available_to_purchase_test() {
		Gum gumTest = new Gum("U-Chews", new BigDecimal("0.85"));
		for(int i = 1; i<6; i++) {
			gumTest.purchaseItem();
		}
		Assert.assertEquals(false, gumTest.isAvailableToPurchase());
	}
	
	@Test
	public void get_price_test() {
		Gum gumTest = new Gum("U-Chews", new BigDecimal("0.85"));
		BigDecimal expected = new BigDecimal("0.85");
		Assert.assertEquals(expected, gumTest.getPrice());
	}
	

}
