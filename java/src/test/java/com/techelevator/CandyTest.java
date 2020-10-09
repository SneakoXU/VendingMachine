package com.techelevator;
import org.junit.Assert;
import org.junit.Test;

import com.techelevator.Candy;

public class CandyTest {
	@Test
	public void get_sound_test() {
		Candy candyTest = new Candy("test", 1.00);
		String expectedString = "Munch Munch, Yum!";
		Assert.assertEquals(expectedString, candyTest.getSound());
				
	}

}
