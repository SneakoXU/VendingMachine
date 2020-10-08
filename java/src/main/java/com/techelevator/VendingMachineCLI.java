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
	
	private static final String PRINT_MENU_FEED = "Feed Money";
	private static final String PRINT_MENU_SELECT = "Select Product";
	private static final String PRINT_MENU_FINISH = "Finish Transaction";
	private static final String[] PRINT_MENU_OPTIONS = { PRINT_MENU_FEED, PRINT_MENU_SELECT, PRINT_MENU_FINISH};


	private Menu menu;
//	public  ReadFile output = new ReadFile();
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				String path = "C:\\Users\\Student\\workspace\\mod1-capstone-team-8\\java\\vendingmachine.csv";
				File inputFile = new File(path);
				List<Items> inventoryList = new ArrayList<>();
				try{
					Scanner fileScanner = new Scanner(inputFile);
					
					fileScanner.useDelimiter("\\|");
					while(fileScanner.hasNextLine()) {
					System.out.println(fileScanner.nextLine());
					}
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
				
				
				
			
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				 choice = (String) menu.getChoiceFromOptions(PRINT_MENU_OPTIONS);
				// do purchase
				
			}
		}
	}

	public static void main(String[] args) {
		
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
		
		
		

}
