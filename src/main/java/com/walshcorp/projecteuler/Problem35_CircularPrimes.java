package com.walshcorp.projecteuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The number, 197, is called a circular prime because all rotations of the
 * digits: 197, 971, and 719, are themselves prime.<br />
 * <br />
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,
 * 73, 79, and 97.<br />
 * <br />
 * How many circular primes are there below one million?
 * 
 * @author martin
 * 
 */
public class Problem35_CircularPrimes implements ProblemInterface {
	private Map<Integer, Boolean> primes = new HashMap<Integer, Boolean>();

	@Override
	public void solve() {
		int limit = 1000000;
		int numberOfCircularPrimes = 0;

		for (int i = 2; i < limit; i++) {
			if (isCircularPrime(i)) {
				numberOfCircularPrimes++;
			}
		}
		System.out.println("Problem 35: " + numberOfCircularPrimes);
	}

	private boolean isCircularPrime(int number) {
		boolean circularPrime = false;
		if (number < 10) {
			if (isPrime(number)) {
				circularPrime = true;
			}
		} else {
			List<String> rotations = getRotations("" + number);
			boolean allPrime = true;
			for (String str : rotations) {
				if (!str.startsWith("0")) {
					if (!isPrime(Integer.parseInt(str))) {
						allPrime = false;
						break;
					}
				}
			}
			circularPrime = allPrime;
		}
		return circularPrime;
	}

	/**
	 * Gets all numbers that can be made by rotating the digits clockwise.
	 * 
	 * @param number
	 * @return
	 */
	private List<String> getRotations(String number) {
		List<String> rotations = new ArrayList<String>();
		int len = number.length();
		int offset = 0;
		while (offset < len) {
			char[] chars = new char[len];
			for (int i = 0; i < len; i++) {
				int pos = i + offset;
				if (pos >= len) {
					pos -= len;
				}
				chars[i] = number.charAt(pos);
			}
			rotations.add(new String(chars));
			offset++;
		}

		return rotations;
	}

	private boolean isPrime(int number) {
		if (!primes.containsKey(number)) {
			boolean prime = true;
			double limit = Math.sqrt(number);
			if (number == 1) {
				prime = false;
			} else {
				for (int i = 2; i <= limit; i++) {
					if (number % i == 0) {
						prime = false;
						break;
					}
				}
			}
			primes.put(number, prime);
		}
		return primes.get(number);
	}
}
