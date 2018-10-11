package com.naren;

public class DateCalculator {

	private static String[] MONTH = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV",
			"DEC" };

	public static int getMonthNo(CustomDate date) {
		String m = date.getMonth();
		for (int i = 0; i < MONTH.length; i++) {
			if (MONTH[i].equals(m)) {
				return i + 1;
			}
		}
		return -1;
	}

	public static int getDaydiffrence(CustomDate date1, CustomDate date2) {
		return date2.getDay() - date1.getDay();
	}

	public static int getDaydiffrence(String date1, String date2) {
		CustomDate d1 = new CustomDate(date1);
		CustomDate d2 = new CustomDate(date2);
		return getDaydiffrence(d1, d2);
	}
}
