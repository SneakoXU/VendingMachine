package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ReadFile {
	private Map <String, Items> inventory = new HashMap<>();
	
	
	
	public Map <String, Items> getInventory(){
		String path = "C:\\Users\\Student\\workspace\\mod1-capstone-team-8\\java\\vendingmachine.csv";
		File inputFile = new File(path);
		List<Items> inventoryList = new ArrayList<>();
		
		try{
			Scanner fileScanner = new Scanner(inputFile);
			
			fileScanner.useDelimiter("\\|");
			System.out.println(fileScanner.nextLine());
			System.out.println(fileScanner.nextLine());
			System.out.println(fileScanner.nextLine());
			System.out.println(fileScanner.nextLine());
			while(fileScanner.hasNextLine());
//		String line = fileScanner.nextLine();
//		String[] lines = line.split("\\|");
		if(fileScanner.nextLine().contains("Chip")) {
			Chips chipItem = new Chips();
		}
//			Items chipItem = new Items(lines[1], Double.parseDouble(lines[2]));
//			inventory.put(lines[0], chipItem);
//		}
//		if(lines[3].equals("Candy")) {
//			Items candyItem = new Items(lines[1], Double.parseDouble(lines[2]));
//			inventory.put(lines[0], candyItem);
//		}
//		if(lines[3].equals("Drink")) {
//			Items drinkItem = new Items(lines[1], Double.parseDouble(lines[2]));
//			inventory.put(lines[0], drinkItem);
//		}
//		if(lines[3].equals("Gum")) {
//			Items gumItem = new Items(lines[1], Double.parseDouble(lines[2]));
//			inventory.put(lines[0], gumItem);
//		}
		
		
		
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return inventory;
		
	
}
	public void printMap() {
		getInventory();
		Set <String> mapSet = inventory.keySet();
		for(String set : mapSet) {
			System.out.println(set + " " + inventory.get(set));
		}
	}
	
	public ReadFile() {
		
	}
	
	
}

