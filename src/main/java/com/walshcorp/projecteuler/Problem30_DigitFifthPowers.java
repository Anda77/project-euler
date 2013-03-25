package com.walshcorp.projecteuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Surprisingly there are only three numbers that can be written as the sum of
 * fourth powers of their digits:<br />
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4<br />
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4<br />
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4<br />
 * <br />
 * As 1 = 14 is not a sum it is not included.<br />
 * <br />
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.<br />
 * <br />
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 * 
 * @author martin
 * 
 */
public class Problem30_DigitFifthPowers implements ProblemInterface {
	private Map<Integer, Integer> powerMap = new HashMap<Integer, Integer>();

	@Override
	public void solve() {
		int sum = 0;

		// Upper limit is 9^5 multipled by the number of digits:
		// By investigation, limit to number of digits is 6.
		int limit = 6 * powerOfFive(9);
		for (int i = 2; i <= limit; i++) {
			if (sumOfDigitsToPowerOfFiveIsNumber(i)) {
				sum += i;
			}
		}
		System.out.println("Problem 30: " + sum);

	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	private Boolean sumOfDigitsToPowerOfFiveIsNumber(int number) {
		int sum = 0;
		List<Integer> digits = breakNumberIntoDigits(number);
		for (Integer digit : digits) {
			sum += powerOfFive(digit);
		}
		return sum == number;
	}

	/**
	 * Break given number into a list of digits.
	 * 
	 * @param number
	 * @return
	 */
	private List<Integer> breakNumberIntoDigits(Integer number) {
		List<Integer> digits = new ArrayList<Integer>();
		String str = "" + number;
		for (int i = 0; i < str.length(); i++) {
			digits.add(Integer.parseInt("" + str.charAt(i)));
		}
		return digits;
	}

	/**
	 * Returns, and stores, the given digit to the power of 5.
	 * 
	 * @param n
	 *            (digit from 0 to 9)
	 * @return
	 */
	private Integer powerOfFive(Integer n) {
		Integer power = null;
		if (powerMap.containsKey(n)) {
			power = powerMap.get(n);
		} else {
			power = (n * n * n * n * n);
			powerMap.put(n, power);
		}
		return power;
	}
}
