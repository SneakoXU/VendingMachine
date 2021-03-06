package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
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
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	
	private static final String PRINT_MENU_FEED = "Feed Money";
	private static final String PRINT_MENU_SELECT = "Select Product";
	private static final String PRINT_MENU_FINISH = "Finish Transaction";
	private static final String[] PRINT_MENU_OPTIONS = {PRINT_MENU_FEED, PRINT_MENU_SELECT, PRINT_MENU_FINISH};


	private Menu menu;
	List<Items> purchasedObjects = new ArrayList<Items>();
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			VendingMachine vendingMachine = new VendingMachine();
			File newFile = vendingMachine.getInputFile();
			Map<String, Items> inventory = vendingMachine.readInventory(newFile);
			
			
			if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("The END!");
				System.exit(0);
			}
			
			
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
							System.out.println("--- Enter amount you would like to feed or (R)eturn to previous menu: ");
							
							Scanner in = new Scanner(System.in);
							String input = in.nextLine();
							
							if(input.toUpperCase().equals("R")) {
								break;
							}else {
								BigDecimal amountEntered = new BigDecimal(input);
								vendingMachine.feedMoney(amountEntered);
								vendingMachine.log("FEED MONEY: ", amountEntered, vendingMachine.getBalance());
								System.out.printf("--- Current balance is: $%.2f\n\n", vendingMachine.getBalance());
							}
						}catch(NumberFormatException e) {
							System.out.println("--- The machine only accepts $1s, $2s, $5s, and $10s");
						}
					}
					
				}else if(choice2.equals(PRINT_MENU_SELECT)) {
					while(true) {
						Set<String> inventoryItems = inventory.keySet();
						for(String items : inventoryItems) {
							System.out.println(items + " " + inventory.get(items).toString());
							}
						System.out.println("--- Please enter the item you would like to purchase or (R)eturn to previous menu: ");
						
						Scanner in = new Scanner(System.in);
						String input = in.nextLine().toUpperCase();
						
						if(input.toUpperCase().equals("R")) {
							break;
					}if(inventory.containsKey(input)) {
						//NOT SURE IF THIS IS RIGHT SINCE IT CHANGES IT TO AN INT!!!!
						//int balanceInt = vendingMachine.balance.intValue();
						//NOT SURE IF THIS IS RIGHT SINCE IT CHANGES IT TO AN INT!!!!
						//int priceInt = inventory.get(input).getPrice().intValue();
//						balanceInt >= priceInt
						if(inventory.get(input).isAvailableToPurchase() && (vendingMachine.balance.compareTo(inventory.get(input).getPrice()) == 1) || (vendingMachine.balance.compareTo(inventory.get(input).getPrice()) == 0)){
							inventory.get(input).purchaseItem();
							purchasedObjects.add(inventory.get(input));
							vendingMachine.balance = vendingMachine.balance.subtract(inventory.get(input).getPrice());
							vendingMachine.log(inventory.get(input).getName(), (vendingMachine.balance.add(inventory.get(input).getPrice())), vendingMachine.balance);
							System.out.printf("\n\n --- Item selected: %10s | Item price: $ %.2f | Remaining balance: $ %.2f || \n\n\n", inventory.get(input).getName(), inventory.get(input).getPrice(), vendingMachine.balance);
						}
						if(vendingMachine.balance.compareTo(new BigDecimal("0.00")) == 0) {
							System.out.println("***Balance is $0.00, please insert more money to purchase more items! ***");
							break;							
						}
//						else if(!inventory.get(input).isAvailableToPurchase()) {
//							System.out.println("\n***SOLD OUT***\n");
//							break;
//						}
//					if(vendingMachine.balance < inventory.get(input).getPrice()) {
					if(vendingMachine.balance.compareTo(inventory.get(input).getPrice()) == -1){	
							System.out.println("*** Insufficient funds, please give me money! ***");
							break;
						}
					}else {
						System.out.println("*** Invalid option, try again! ***");
						
					}
					}
				} else if(choice2.equals(PRINT_MENU_FINISH)) {
					vendingMachine.changeReturned();
					vendingMachine.logFile();
					//vendingMachine.balance = new BigDecimal("0.00");
					System.out.printf("--- Final balance: $%.2f\n\n", vendingMachine.getBalance());
					
					for(Items items: purchasedObjects) {
						String sound = items.getSound();
						System.out.println(sound);
						}
					break;
				} 
			}
		}
		}
	}

	public static void main(String[] args) throws IOException {
		
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
		
		
		

}
