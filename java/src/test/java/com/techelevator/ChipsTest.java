package com.techelevator;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Assert;
import org.junit.Test;

public class ChipsTest {

	
	@Test
	public void get_sound_test() {
		Chips chipsTest = new Chips("test", new BigDecimal("1.00"));
		String expectedString = "Crunch Crunch, Yum!";
		Assert.assertEquals(expectedString, chipsTest.getSound());
				
	}
	
	@Test
	public void chips_purchase_test() {
		Chips chipsTest = new Chips("Potato Crisps", new BigDecimal("3.05"));
		chipsTest.purchaseItem();
		Assert.assertEquals(4, chipsTest.getNumberOfItems());
	}
	
	@Test
	public void is_available_to_purchase_test() {
		Chips chipsTest = new Chips("Potato Crisps", new BigDecimal("3.05"));
		Assert.assertEquals(true, chipsTest.isAvailableToPurchase());
	}
	
	@Test
	public void not_available_to_purchase_test() {
		Chips chipsTest = new Chips("Potato Crisps", new BigDecimal("3.05"));
		for(int i = 1; i<6; i++) {
			chipsTest.purchaseItem();
		}
		Assert.assertEquals(false, chipsTest.isAvailableToPurchase());
	}
	
	@Test
	public void get_price_test() {
		Chips chipsTest = new Chips("Potato Crisps", new BigDecimal("3.05"));
		BigDecimal expected = new BigDecimal("3.05");
		Assert.assertEquals(expected, chipsTest.getPrice());
	}
	
	@Test
	public void to_string_test() {
		Chips chipsTest = new Chips("Potato Crisps", new BigDecimal("3.05"));
		DecimalFormat moneyFormat = new DecimalFormat("#.00");
		String expectedString= String.format(" %1$-20s %2$-10s %3$s", chipsTest.getName(), "$" + moneyFormat.format(chipsTest.getPrice()), chipsTest.getNumberOfItems());
		Assert.assertEquals(expectedString, chipsTest.toString());
	}

}
