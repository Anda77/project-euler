package com.walshcorp.projecteuler;

import java.util.HashMap;
import java.util.Map;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.<br />
 * <br />
 * Find the sum of all numbers which are equal to the sum of the factorial of
 * their digits.<br />
 * <br />
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 * @author martin
 * 
 */
public class Problem34_DigitFactorials implements ProblemInterface {
	Map<Integer, Integer> factorials = new HashMap<Integer, Integer>();
	int totalSum = 0;

	@Override
	public void solve() {
		int limit = getLimit();
		for (int i = 145; i <= limit; i++) {
			if (i == sumOfFactorialOfDigits(i)) {
				totalSum += i;
			}
		}
		System.out.println("Problem 34: " + totalSum);
	}

	/**
	 * Returns the sum of the factorial of each individual digit
	 * 
	 * @param num
	 * @return
	 */
	private int sumOfFactorialOfDigits(int num) {
		int sum = 0;
		String numStr = "" + num;
		for (int i = 0; i < numStr.length(); i++) {
			int digit = Integer.parseInt("" + numStr.charAt(i));
			int fac = -1;
			if (factorials.containsKey(digit)) {
				fac = factorials.get(digit);
			} else {
				fac = factorial(digit);
				factorials.put(digit, fac);
			}
			sum += fac;
		}

		return sum;
	}

	private int getLimit() {
		// Limit number of digits * 9!
		// Need to find convergence for max number of digits.

		int sum = -1;
		int digits = 2;
		boolean found = false;
		int nineFactorial = factorial(9);

		while (!found) {
			String sumStr = "" + digits * nineFactorial;
			if (sumStr.length() < digits) {
				found = true;
			} else {
				digits++;
			}
		}
		// Return the limit:
		return (digits - 1) * nineFactorial;
	}

	/**
	 * Returns factorial of given number.
	 * 
	 * @param n
	 * @return
	 */
	private int factorial(int n) {
		int ans = 1;
		if (n > 1) {
			ans = ans * factorial(n - 1);
			ans = ans * n;
		}

		return ans;
	}
}
