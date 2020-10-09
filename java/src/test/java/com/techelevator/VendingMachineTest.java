package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {
	
	@Test
	public void feed_money_test() {
		VendingMachine test = new VendingMachine();
		double expectedAmount = 4.00;
		double testAmount = 5.00;
		double delta = 1.00;
		test.feedMoney(testAmount);
		Assert.assertEquals(expectedAmount, testAmount, delta);
		
	}
	
	

}
