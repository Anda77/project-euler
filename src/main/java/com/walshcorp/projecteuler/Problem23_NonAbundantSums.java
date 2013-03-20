package com.walshcorp.projecteuler;

import java.util.HashMap;
import java.util.Map;

/**
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 * 
 * @author martin
 * 
 */
public class Problem23_NonAbundantSums implements ProblemInterface {
	private Map<Integer, Boolean> abundantNumbers = new HashMap<Integer, Boolean>();

	@Override
	public void solve() {
		int sum = 0;
		for (int i = 1; i <= 28123; i++) {
			if (!isSumOfTwoAbundantNumbers(i)) {
				sum += i;
			}
		}
		System.out.println("Problem 23: " + sum);
	}

	/**
	 * Checks whether a number can be expressed as the sum of two abundant
	 * numbers.
	 * 
	 * @param num
	 * @return
	 */
	private boolean isSumOfTwoAbundantNumbers(int num) {
		boolean condition = false;
		int limit = 0;
		if (num % 2 == 0) {
			limit = num / 2;
		} else {
			limit = num / 2 + 1;
		}

		for (int i = limit; i > 0; i--) {
			if (isAbundantNumber(i)) {
				int remainder = num - i;
				if (isAbundantNumber(remainder)) {
					condition = true;
					break;
				}
			}
		}
		return condition;
	}

	/**
	 * Checks whether a number is an abundant number and stores for future use.
	 * 
	 * @param num
	 * @return
	 */
	private boolean isAbundantNumber(int num) {
		boolean abundantNumber = false;
		if (abundantNumbers.containsKey(num)) {
			abundantNumber = abundantNumbers.get(num);
		} else {
			int limit = num / 2;
			int sum = 0;
			for (int i = 1; i <= limit; i++) {
				if (num % i == 0) {
					sum += i;
				}
			}
			if (sum > num) {
				abundantNumber = true;
			}
			abundantNumbers.put(num, abundantNumber);
		}
		return abundantNumber;
	}
}
