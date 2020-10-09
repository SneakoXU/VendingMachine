package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachine {
	
	public double balance;
	public List <String> list;
	
	
	public VendingMachine() {
		balance = 0;
		List<String> list = new ArrayList<String>();
	}
	
	
	public File getInputFile() {
		String path ="vendingmachine.csv";
		File inputFile = new File(path);
		
		if( !inputFile.exists()) {
			System.out.println(path + " doesn't exist");
			System.exit(1);
			
		}else if (!inputFile.isFile()) {
			System.out.println(path + " isn't a file");
			System.exit(1);
		}
		return inputFile;
	}
	
	public Map<String, Items> readInventory (File inputFile) throws FileNotFoundException{
		Map<String, Items> inventoryMap = new LinkedHashMap<>();
		Scanner fileScanner = new Scanner(inputFile);
		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String[] sections = line.split("\\|");
			
			if(sections[3].equals("Chip")) {
				Chips chipItem = new Chips(sections[1], Double.parseDouble(sections[2]));
				inventoryMap.put(sections[0], chipItem);
			}else if(sections[3].equals("Candy")) {
				Candy candyItem = new Candy(sections[1], Double.parseDouble(sections[2]));
				inventoryMap.put(sections[0], candyItem);
			}else if(sections[3].equals("Drink")) {
				Beverages beverageItem = new Beverages(sections[1], Double.parseDouble(sections[2]));
				inventoryMap.put(sections[0], beverageItem);
		}else if(sections[3].equals("Gum")) {
			Gum gumItem = new Gum(sections[1], Double.parseDouble(sections[2]));
			inventoryMap.put(sections[0], gumItem);
	}
		
		
		
	}
		return inventoryMap;
	}
	
	public void feedMoney(double moneyAdded) {
		Set<Double> price = new HashSet <Double> (Arrays.asList(
			new Double[] {1.00,2.00,5.00,10.00}));
			if(price.contains(moneyAdded)) {
				balance += moneyAdded;
			}else {
					System.out.println("Invalid currency amount. Only $1s, $2s, $5s and $10s\n ");
				}
		}
		
	public double getBalance() {
			return balance;
			}
	
	public void changeReturned() {
		double[] change = new double[] {0.25, 0.10, 0.05};
		String[] coinNames = new String[] {"Quarter(s)", "Dime(s)", "Nickel(s)"};
		for(int i=0; i<change.length; i++) {
			int counter;
			counter = (int) (balance/change[i]);
			
			balance -= (change[i] * counter);
			System.out.println(counter + " " + coinNames[i]);
		}
	}
		
	public void logFile() throws IOException {
		File outputFile = new File("Log.txt");
		List<String> list = getList();
		try(FileWriter logWriter = new FileWriter(outputFile, true)) {
			for(String string : list) {
				logWriter.write(string);
				logWriter.write("\n");
			}
		}
		
	}	
//	public List<String> log(String name, double beginningAmount, double endAmount) {
//		LocalDateTime time = LocalDateTime.now();
//		DecimalFormat myFormat = new DecimalFormat("#.00");
//		String string = time + " " + name + " " + beginningAmount + " " + myFormat.format(endAmount);
		// list.add(string);
//		return list;
//	}
	public List<String> getList() {
		return this.list;
	}
		
	}
		
	
		

	

