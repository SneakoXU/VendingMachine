package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;

public class VendingMachine {
	
	public BigDecimal balance;
	public List <String> list = new ArrayList<String>();
	private static final BigDecimal NICKEL = new BigDecimal("0.05");
	private static final BigDecimal DIME = new BigDecimal("0.10");
	private static final BigDecimal QUARTER = new BigDecimal("0.25");
	private static final BigDecimal DOLLAR = new BigDecimal("1");
	private static final BigDecimal TWO_DOLLARS = new BigDecimal("2");
	private static final BigDecimal FIVE_DOLLARS = new BigDecimal("5");
	private static final BigDecimal TEN_DOLLARS = new BigDecimal("10");
	
	
	
	
	
	public VendingMachine() {
		balance = new BigDecimal("0.00");
	//	List<String> list ;
	}
	
	public BigDecimal getBalance() {
		return balance;
		}

	public List<String> getList() {
		return this.list;
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
				Chips chipItem = new Chips(sections[1], new BigDecimal(sections[2]));
				inventoryMap.put(sections[0], chipItem);
			}else if(sections[3].equals("Candy")) {
				Candy candyItem = new Candy(sections[1], new BigDecimal(sections[2]));
				inventoryMap.put(sections[0], candyItem);
			}else if(sections[3].equals("Drink")) {
				Beverages beverageItem = new Beverages(sections[1], new BigDecimal(sections[2]));
				inventoryMap.put(sections[0], beverageItem);
		}else if(sections[3].equals("Gum")) {
			Gum gumItem = new Gum(sections[1], new BigDecimal(sections[2]));
			inventoryMap.put(sections[0], gumItem);
			}
		}
		return inventoryMap;
	}
	
	public void feedMoney(BigDecimal moneyAdded) {
		Set<BigDecimal> cash = new HashSet <BigDecimal> (Arrays.asList(
			new BigDecimal[] {DOLLAR,TWO_DOLLARS,FIVE_DOLLARS,TEN_DOLLARS}));
			if(cash.contains(moneyAdded)) {
				
				balance = balance.add(moneyAdded);
			}else {
					System.out.println("Invalid currency amount. Only $1s, $2s, $5s and $10s\n ");
				}
		}
		

	
	public void changeReturned() {
		BigDecimal[] change = new BigDecimal[] {QUARTER, DIME, NICKEL};
		String[] coinNames = new String[] {"Quarter(s)", "Dime(s)", "Nickel(s)"};
		for(int i=0; i<change.length; i++) {
			int counter;
//			counter = (int) (balance/change[i]);
			//NOT SURE IF THIS IS RIGHT SINCE IT CHANGES IT TO AN INT!!!!
			int balanceInt = balance.intValue();
			if(balanceInt == 0 || change[i].intValue() == 0) {
				break;
			}else {
			
			counter = balanceInt/change[i].intValue();
			
			balanceInt -= (change[i].intValue() * counter);
			System.out.println(counter + " " + coinNames[i]);
			}
		}
	}
		
	public void log(String name, BigDecimal beginningAmount, BigDecimal endAmount) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
		LocalDateTime time = LocalDateTime.now();
		DecimalFormat moneyFormat = new DecimalFormat("#.00");
		String string = String.format(" %1$-20s %2$-15s %3$s %4$s", "> " + dtf.format(time), name, "$" + beginningAmount, "$" + endAmount);
		 list.add(string);
//		return list;
	}
	
	public void logFile() throws IOException {
		File outputFile = new File("Log.txt");
		List<String> list = getList();
		try(PrintWriter logWriter = new PrintWriter(new FileOutputStream(outputFile, true))) {
			for(String string : list) {
				logWriter.write(string);
				logWriter.write("\n");
			}
		}
		
	}
	
	}
		
	
		

	

