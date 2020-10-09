package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	
	private static final String PRINT_MENU_FEED = "Feed Money";
	private static final String PRINT_MENU_SELECT = "Select Product";
	private static final String PRINT_MENU_FINISH = "Finish Transaction";
	private static final String PRINT_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String[] PRINT_MENU_OPTIONS = { PRINT_MENU_FEED, PRINT_MENU_SELECT, PRINT_MENU_FINISH, PRINT_MENU_OPTION_DISPLAY_ITEMS};


	private Menu menu;
	List<Items> purchasedObjects = new ArrayList<Items>();
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			VendingMachine vendingMachine = new VendingMachine();
			File newFile = vendingMachine.getInputFile();
			Map<String, Items> inventory = vendingMachine.readInventory(newFile);
			
			
			
			
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			Set<String> inventoryItems = inventory.keySet();
			for(String items : inventoryItems) {
				System.out.println(items + " " + inventory.get(items).toString());
				}
				
				
				
				
			
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
				 String choice2 = (String) menu.getChoiceFromOptions(PRINT_MENU_OPTIONS);
				if(choice2.toUpperCase() == "R") {
					break;
				}
				if(choice2.contentEquals(PRINT_MENU_FEED)) {
					while(true) {
						try {
							System.out.println("Enter amount you would like to feed or (R)eturn to previous menu: ");
							
							Scanner in = new Scanner(System.in);
							String input = in.nextLine();
							
							if(input.toUpperCase().equals("R")) {
								break;
							}else {
								double amountEntered = Double.parseDouble(input);
								vendingMachine.feedMoney(amountEntered);
								System.out.println("Current balance $" + vendingMachine.getBalance());
							}
						}catch(NumberFormatException e) {
							System.out.println("The machine only accepts $1s, $2s, $5s, and $10s");
						}
					}
					
				}else if(choice2.equals(PRINT_MENU_SELECT)) {
					while(true) {
						System.out.println("Please enter the item you would like to purchase or (R)eturn to previous menu: ");
						
						Scanner in = new Scanner(System.in);
						String input = in.nextLine();
						
						if(input.toUpperCase().equals("R")) {
							break;
					}else if(inventory.containsKey(input.toUpperCase())) {
						if(inventory.get(input).isAvailableToPurchase() && vendingMachine.getBalance() >= inventory.get(input).getPrice()){
							inventory.get(input).purchaseItem();
							purchasedObjects.add(inventory.get(input));
							vendingMachine.balance -= inventory.get(input).getPrice();
	//						vendingMachine.log(inventory.get(input).getName(), (vendingMachine.balance + inventory.get(input).getPrice()), vendingMachine.balance);
							System.out.println("purchased");
							inventory.get(input).purchaseItem();
							System.out.println("Item selected: " + inventory.get(input).getName() + " | " + "Item price: " + inventory.get(input).getPrice() + " | " + "Remaining balance: " + vendingMachine.balance);
						}else if(!inventory.get(input).isAvailableToPurchase()) {
							System.out.println("Sold out");
							break;
						}else {
							System.out.println("Insufficient funds, please give me money!");
							break;
						}
					}else {
						System.out.println("Invalid option, try again!");
						break;
					}
					}
				} else if(choice2.equals(PRINT_MENU_FINISH)) {
					vendingMachine.changeReturned();
					//vendingMachine.log
					vendingMachine.balance = 0;
					System.out.println("Final balance: $" + vendingMachine.getBalance());
					System.out.println("");
					
					for(Items items: purchasedObjects) {
						String sound = items.getSound();
						System.out.println(sound);
						}
					break;
				} else if (choice.equals(PRINT_MENU_OPTION_DISPLAY_ITEMS)) {
					// display vending machine items
				Set<String> inventoryItems = inventory.keySet();
				for(String items : inventoryItems) {
					System.out.println(items + "\t" + inventory.get(items).getName() + "\t" + inventory.get(items).getPrice() + "\t" + inventory.get(items).getNumberOfItems());
				}
					
				}
			}
		}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
		
		
		

}
