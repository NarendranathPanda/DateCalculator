package com.naren;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DateCalculatorTest {
	public static String[] INVALID_DATE = { "45-11-2014", "-1-11-2014", "29-02-2014" };

	@Test
	public void testIsValidDate() {
		final String dateString1 = "12-11-2014";
		assertTrue(DateCalculator.isValidDate(dateString1));
	}

	@Test(expected = InvalidDateFormatException.class)
	public void testInValidDateFormat() {
		final String dateString1 = "45-11-2014-dfsf";
		assertFalse(DateCalculator.isValidDate(dateString1));
	}

	@Test(expected = InvalidDateFormatException.class)
	public void testInValidDate() {
		final String dateString1 = "45-01-2014";
		assertFalse(DateCalculator.isValidDate(dateString1));
	}

	@Test(expected = InvalidDateFormatException.class)
	public void testInValidDateWrongFeb() {
		final String dateString1 = "30-02-2014";
		assertFalse(DateCalculator.isValidDate(dateString1));
	}

	@Test
	public void testInValidDateLeapYear() {
		final String dateString1 = "29-02-2012";
		assertTrue(DateCalculator.isValidDate(dateString1));
	}

	@Test(expected = InvalidDateFormatException.class)
	public void testInValidDateMonth() {
		final String dateString1 = "29-14-2012";
		assertTrue(DateCalculator.isValidDate(dateString1));
	}

	@Test(expected = InvalidDateFormatException.class)
	public void testInValidDateMonth2() {
		final String dateString1 = "(05-10-2012";
		assertTrue(DateCalculator.isValidDate(dateString1));
	}

	@Test
	public void testFindEarlierDate() {
		final String dateString1 = "12-11-2014";
		final String dateString2 = "08-11-2014";
		final CustomDate date1 = new CustomDate(dateString1);
		final CustomDate date2 = new CustomDate(dateString2);
		assertEquals(date2, DateCalculator.findEarlierDate(date1, date2));
	}

	@Test
	public void testFindEarlierDateFromDifferentMonth() {
		final String dateString1 = "20-11-2014";
		final String dateString2 = "20-10-2014";
		final CustomDate date1 = new CustomDate(dateString1);
		final CustomDate date2 = new CustomDate(dateString2);
		assertEquals(date2, DateCalculator.findEarlierDate(date1, date2));
	}

	@Test
	public void testFindEarlierDateFromDifferentYears() {
		final String dateString1 = "20-OCT-2014";
		final String dateString2 = "20-OCT-2018";
		final CustomDate date1 = new CustomDate(dateString1);
		final CustomDate date2 = new CustomDate(dateString2);
		assertEquals(date1, DateCalculator.findEarlierDate(date1, date2));
	}

	@Test
	public void testGetDaydiffrenceCustomDateCustomDateDiffrentDay() {
		final String dateString1 = "20-10-2018";
		final String dateString2 = "25-10-2018";
		int daydiffrence = DateCalculator.getDiffrence(dateString1, dateString2);
		assertEquals(5, daydiffrence);
	}
	
	@Test
	public void testGetDaydiffrenceCustomDateCustomDateDiffrentMonth() {
		final String dateString1 = "20-10-2018";
		final String dateString2 = "25-11-2018";
		int daydiffrence = DateCalculator.getDiffrence(dateString1, dateString2);
		assertEquals(36, daydiffrence);
	}

	@Test
	public void testGetDaydiffrenceStringString() {
		final String dateString1 = "20-10-2018";
		final String dateString2 = "25-10-2018";
		int daydiffrence = DateCalculator.getDaydiffrence(dateString1, dateString2);
		assertEquals(5, daydiffrence);
	}

	@Test
	public void testIncreaseDays() {
		final String dateStringOld = "20-10-2018";
		final String dateStringNew = "21-10-2018";
		assertEquals(dateStringNew, DateCalculator.increaseDays(dateStringOld).getDateString());
	}
	@Test
	public void testIncreaseDaysToGetNewMonth() {
		final String dateStringOld = "30-10-2018";
		final String dateStringNew = "31-10-2018";
		assertEquals(dateStringNew, DateCalculator.increaseDays(dateStringOld).getDateString());
	}
	@Test
	public void testIncreaseDaysToGetNewMonth2() {
		final String dateStringOld = "31-10-2018";
		final String dateStringNew = "1-11-2018";
		assertEquals(dateStringNew, DateCalculator.increaseDays(dateStringOld).getDateString());
	}
	@Test
	public void testIncreaseDaysToGetNewYear() {
		final String dateStringOld = "31-12-2018";
		final String dateStringNew = "1-1-2019";
		assertEquals(dateStringNew, DateCalculator.increaseDays(dateStringOld).getDateString());
	}
	@Test
	public void testIncreaseDaysToGetFebLeapYear() {
		final String dateStringOld = "28-02-2016";
		final String dateStringNew = "29-2-2016";
		assertEquals(dateStringNew, DateCalculator.increaseDays(dateStringOld).getDateString());
	}
	@Test
	public void testIncreaseDaysToGetFeb() {
		final String dateStringOld = "29-02-2016";
		final String dateStringNew = "1-3-2016";
		assertEquals(dateStringNew, DateCalculator.increaseDays(dateStringOld).getDateString());
	}
}
