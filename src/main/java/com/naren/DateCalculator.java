package com.naren;

public class DateCalculator {

	private static int[] MAX_MONTH_DAY = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 30 };

	public static int getDiffrence(String dateString1, String dateString2) {
		int diff = 0;
		isValidDate(dateString1);
		isValidDate(dateString2);
		CustomDate date1 = new CustomDate(dateString1);
		CustomDate date2 = new CustomDate(dateString2);
		String dateString = findEarlierDate(date1, date2).getDateString();
		while (!dateString.equals(dateString2)) {
			dateString = increaseDays(dateString).getDateString();
			diff++;

		}
		return diff;
	}

	public static int getDaydiffrence(CustomDate date1, CustomDate date2) {
		return date2.getDay() - date1.getDay();
	}

	public static int getDaydiffrence(String date1, String date2) {
		CustomDate d1 = new CustomDate(date1);
		CustomDate d2 = new CustomDate(date2);
		return getDaydiffrence(d1, d2);
	}

	public static CustomDate findEarlierDate(CustomDate date1, CustomDate date2) {
		CustomDate earlierdate = findEarlierDateByYear(date1, date2);
		if (earlierdate == null) {
			earlierdate = findEarlierDateByMonth(date1, date2);
			if (earlierdate == null) {
				earlierdate = findEarlierDateByDay(date1, date2);
			}
		}
		return earlierdate;
	}

	private static CustomDate findEarlierDateByDay(CustomDate date1, CustomDate date2) {
		int daydiffrence = getDaydiffrence(date1, date2);
		if (daydiffrence == 0) {
			return date1;
		} else if (daydiffrence > 0) {
			return date1;
		} else {
			return date2;
		}
	}

	private static CustomDate findEarlierDateByMonth(CustomDate date1, CustomDate date2) {
		int monthNo1 = date1.getMonth();
		int monthNo2 = date2.getMonth();
		if (monthNo1 == monthNo2) {
			return null;
		}
		if (monthNo1 > monthNo2) {
			return date2;
		} else {
			return date1;
		}
	}

	private static CustomDate findEarlierDateByYear(CustomDate date1, CustomDate date2) {
		if (date1.getYear() == date2.getYear()) {
			return null;
		}
		if (date1.getYear() > date2.getYear()) {
			return date2;
		} else {
			return date1;
		}
	}

	public static Boolean isValidDate(String dateString) {
		String[] dateSplit = dateString.split("-");
		if (dateSplit.length == 3) {
			CustomDate date = new CustomDate(dateString);
			validateDay(date);
			validateMonth(date);
			validateYear(date);
			return true;
		} else {
			throw new InvalidDateFormatException();
		}
	}

	private static boolean validateYear(CustomDate date) {
		try {
			int year = date.getYear();
			if (year >= 1900 && year <= 2500) {
				return true;
			} else {
				throw new InvalidDateFormatException("Year is not Valid");
			}
		} catch (NumberFormatException e) {
			throw new InvalidDateFormatException("Year is not Valid");
		}
	}

	private static boolean validateMonth(CustomDate date) {
		validateYear(date);
		try {
			int month = date.getMonth();
			if (month >= 1 && month <= 12) {
				return true;
			} else {
				throw new InvalidDateFormatException("Month is not Valid");
			}
		} catch (NumberFormatException e) {
			throw new InvalidDateFormatException("Month is not Valid");
		}
	}

	private static boolean validateDay(CustomDate date) {
		validateMonth(date);
		try {
			int day = date.getDay();

			if (day >= 1 && day <= 31) {
				int max_day = getMaxDayOfTheMonth(date);
				if (day <= max_day)
					return true;
				else {
					throw new InvalidDateFormatException("Invalid Day ");
				}
			} else {
				throw new InvalidDateFormatException("Year is not Valid");
			}
		} catch (NumberFormatException e) {
			throw new InvalidDateFormatException("Year is not Valid");
		}

	}

	private static int getMaxDayOfTheMonth(CustomDate date) {
		int month = date.getMonth();
		int max_day = MAX_MONTH_DAY[month - 1];
		if (month == 2 && isLeapYear(date)) {
			max_day++;
		}
		return max_day;
	}

	private static boolean isLeapYear(CustomDate date) {
		validateYear(date);
		return date.getYear() % 4 == 0;
	}

	public static CustomDate increaseDays(String dateStringOld) {
		CustomDate date = new CustomDate(dateStringOld);
		int day = date.getDay();
		int month = date.getMonth();
		int year = date.getYear();
		if (day < getMaxDayOfTheMonth(date)) {
			return new CustomDate((day + 1) + "-" + month + "-" + year);
		} else {
			if (month < 12) {
				return new CustomDate(01 + "-" + (month + 1) + "-" + year);
			} else {
				return new CustomDate(01 + "-" + 01 + "-" + (year + 1));
			}
		}
	}
}
