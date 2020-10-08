package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private Menu menu;
	public  ReadFile output = new ReadFile();
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items

				output.getInventory();
				
				output.printMap();
				
				
				
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}

	public static void main(String[] args) {
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
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
		
		
		

}
