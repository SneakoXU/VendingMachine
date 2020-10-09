package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {
	@Test
	public void get_sound_test() {
		Gum gumTest = new Gum("test", 1.00);
		String expectedString = "Chew Chew, Yum!";
		Assert.assertEquals(expectedString, gumTest.getSound());
				
	}

}
