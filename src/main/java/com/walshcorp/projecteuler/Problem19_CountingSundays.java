package com.walshcorp.projecteuler;

/**
 * You are given the following information, but you may prefer to do some
 * research for yourself.<br />
 * 1 Jan 1900 was a Monday.<br />
 * Thirty days has September,<br />
 * April, June and November.<br />
 * All the rest have thirty-one,<br />
 * Saving February alone,<br />
 * Which has twenty-eight, rain or shine.<br />
 * And on leap years, twenty-nine.<br />
 * A leap year occurs on any year evenly divisible by 4, but not on a century
 * unless it is divisible by 400.<br />
 * 
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?<br />
 * 
 * @author martin
 * 
 */
public class Problem19_CountingSundays implements ProblemInterface {
	@Override
	public void solve() {
		int noOfSundays = 0;
		for (int year = 1901; year < 2001; year++) {
			noOfSundays += countSundaysInYear(year);
		}
		System.out.println("Problem 19: " + noOfSundays);
	}

	/**
	 * Gets first day of year<br />
	 * 0 = Monday, 1 = Tuesday, 2 = Wednesday, 3 = Thursday, 4 = Friday, 5 =
	 * Saturday, 6 = Saturday
	 * 
	 * @param year
	 * @return
	 */
	private int calculateFirstDayOfYear(int year) {
		int days = 0;
		for (int i = 1900; i < year; i++) {
			if (isLeapYear(year)) {
				days += 366;
			} else {
				days += 365;
			}
		}
		int dayOffset = days % 7;
		if (dayOffset > 6) {
			dayOffset -= 7;
		}
		return dayOffset;
	}

	/**
	 * Returns number of sundays on first of the month in the given year.
	 * 
	 * @param year
	 * @return
	 */
	private int countSundaysInYear(int year) {
		int sundays = 0;
		int firstDay = calculateFirstDayOfYear(year);
		boolean leapYear = isLeapYear(year);

		for (int month = 0; month < 12; month++) {
			int checkDay = firstDayOfMonth(leapYear, firstDay, month);
			if (checkDay == 6) {
				sundays += 1;
			}
		}

		return sundays;
	}

	/**
	 * Returns the first day of the month
	 * 
	 * @param leapYear
	 * @param firstDayOfYear
	 *            Monday = Sunday ... 6 = Sunday
	 * @param monthIndex
	 *            0 = January ... 11 = December
	 * @return
	 */
	private int firstDayOfMonth(boolean leapYear, int firstDayOfYear,
			int monthIndex) {
		int days = 0;

		int firstDayOfMonth = 0;
		switch (monthIndex) {
		case 11:
			// December:
			days += 30;
		case 10:
			// November:
			days += 31;
		case 9:
			// October
			days += 30;
		case 8:
			// September
			days += 31;
		case 7:
			// August
			days += 31;
		case 6:
			// July
			days += 30;
		case 5:
			// June
			days += 31;
		case 4:
			// May
			days += 30;
		case 3:
			// April
			days += 31;
		case 2:
			// March
			days += 28;
		case 1:
			// February
			days += 31;
		case 0:
			// January:
			days += 0;
		}

		// Cater for leap year:
		if (leapYear && monthIndex > 1) {
			days += 1;
		}

		int extraDaysOutsideWeeks = days % 7;

		// Offset:
		firstDayOfMonth = firstDayOfYear + extraDaysOutsideWeeks;

		// Adjust for week length:
		if (firstDayOfMonth > 6) {
			firstDayOfMonth -= 7;
		}

		return firstDayOfMonth;
	}

	private boolean isLeapYear(int year) {
		boolean leapYear = false;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					leapYear = true;
				}
			} else {
				leapYear = true;
			}
		}
		return leapYear;
	}
}
