package com.naren;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateCalculatorTest {

	@Test
	public void testGetMonthNo() {
		final String dateString1 = "20-OCT-2018";
		final CustomDate date1 = new CustomDate(dateString1);
		assertEquals(10, DateCalculator.getMonthNo(date1));
	}

	@Test
	public void testGetDaydiffrenceCustomDateCustomDate() {
		final String dateString1 = "20-OCT-2018";
		final String dateString2 = "25-OCT-2018";
		final CustomDate date1 = new CustomDate(dateString1);
		final CustomDate date2 = new CustomDate(dateString2);
		int daydiffrence = DateCalculator.getDaydiffrence(date1, date2);
		assertEquals(5, daydiffrence);
	}

	@Test
	public void testGetDaydiffrenceStringString() {
		final String dateString1 = "20-OCT-2018";
		final String dateString2 = "25-OCT-2018";
		int daydiffrence = DateCalculator.getDaydiffrence(dateString1, dateString2);
		assertEquals(5, daydiffrence);
	}

}
