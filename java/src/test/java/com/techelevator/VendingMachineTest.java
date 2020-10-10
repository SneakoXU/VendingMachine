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
	public void feed_money_test() {
		VendingMachine test = new VendingMachine();
		double expectedAmount = 4.00;
		double testAmount = 5.00;
		double delta = 1.00;
		test.feedMoney(testAmount);
		Assert.assertEquals(expectedAmount, testAmount, delta);
		
	}
	
	@Test
	public void input_file_should_exist() {
		VendingMachine test = new VendingMachine();
		String testPath = "vendingmachine.csv";
		File testInputFile = new File(testPath);
		Assert.assertEquals("File does not exist", testInputFile, test.getInputFile());
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
