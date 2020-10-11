package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {
	

	@Test
	public void input_file_should_exist() {
		VendingMachine test = new VendingMachine();
		String testPath = "vendingmachine.csv";
		File testInputFile = new File(testPath);
		Assert.assertEquals("Result returned is incorrect", testInputFile, test.getInputFile());
	}
	

	@Test
	public void feed_money_test() {
		VendingMachine test = new VendingMachine();
		test.feedMoney(10);
		//test.feedMoney(testAmount);
		Assert.assertEquals(10, test.getBalance(), 1e-15);
	}
	
	@Test
	public void incorrect_feed_money_test_should_return_zero_balance() {
		VendingMachine test = new VendingMachine();
		test.feedMoney(20);
		//String expected = "Invalid currency amount. Only $1s, $2s, $5s and $10s\n ";
		Assert.assertEquals(0, test.getBalance(), 1e-15);
	}
	
	@Test
	public void a1_should_return_potato_crisps() throws FileNotFoundException {
		VendingMachine test = new VendingMachine();
		String testPath = "vendingmachine.csv";
		File testInputFile = new File(testPath);
		Assert.assertEquals("Potato Crisps", test.readInventory(testInputFile).get("A1").getName());
	}
	

	@Test
	public void a1_should_return_correct_price() throws FileNotFoundException{
		VendingMachine test = new VendingMachine();
		String testPath = "vendingmachine.csv";
		File testInputFile = new File(testPath);
		double expectedPrice = 3.05;
		Assert.assertEquals(expectedPrice, test.readInventory(testInputFile).get("A1").getPrice(), 1e-15);
	}
	
}
