package com.techelevator;

import java.io.File;

public class VendingMachine {
	
	
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

}
