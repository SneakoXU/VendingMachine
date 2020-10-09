package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ChipsTest {
	
	@Test
	public void get_sound_test() {
		Chips chipsTest = new Chips("test", 1.00);
		String expectedString = "Crunch Crunch, Yum!";
		Assert.assertEquals(expectedString, chipsTest.getSound());
				
	}

}
