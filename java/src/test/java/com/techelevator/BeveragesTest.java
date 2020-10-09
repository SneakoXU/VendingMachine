package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class BeveragesTest {
	
	@Test
	public void get_sound_test() {
		Beverages beveragesTest = new Beverages("test", 1.00);
		String expectedString = "Glug Glug, Yum!";
		Assert.assertEquals(expectedString, beveragesTest.getSound());
				
	}

}
