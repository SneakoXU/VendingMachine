package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	
	public VendingMachine() {
		
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
		Map<String, Items> inventoryMap = new HashMap<>();
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
		
		//return inventoryMap;
		
	}
		return inventoryMap;
	}
}
