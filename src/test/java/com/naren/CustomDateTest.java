package com.naren;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomDateTest {
	final String dateString = "20-OCT-2018";
	final CustomDate date = new CustomDate(dateString);

	@Test
	public void testGetDay() {
		assertEquals(20, date.getDay());
	}

	@Test
	public void testGetMonth() {
		assertEquals("OCT", date.getMonth());
	}

	@Test
	public void testGetYear() {
		assertEquals(2018, date.getYear());
	}

}
