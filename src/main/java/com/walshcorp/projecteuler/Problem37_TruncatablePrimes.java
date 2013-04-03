package com.walshcorp.projecteuler;

import java.util.HashMap;
import java.util.Map;

/**
 * The number 3797 has an interesting property. Being prime itself, it is
 * possible to continuously remove digits from left to right, and remain prime
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.<br />
 * <br />
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.<br />
 * <br />
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * 
 * @author martin
 * 
 */
public class Problem37_TruncatablePrimes implements ProblemInterface {
	Map<Integer, Boolean> primes = new HashMap<Integer, Boolean>();

	@Override
	public void solve() {
		int sum = 0;
		int count = 0;
		int i = 10;
		// We know there are only 11 primes from the question...
		while (count < 11) {
			if (isTruncatablePrime(i)) {
				sum += i;
				count++;
			}
			i++;
		}

		System.out.println("Problem 37: " + sum);
	}

	private boolean isTruncatablePrime(int number) {
		String leftStr = "" + number;
		String rightStr = "" + number;

		boolean truncatable = true;
		// Check Left
		while (truncatable) {
			if (leftStr.length() > 0) {
				truncatable = isPrime(Integer.parseInt(leftStr));
				leftStr = leftStr.substring(1);
			} else {
				break;
			}
		}
		if (truncatable) {
			// Check Right
			while (truncatable) {
				if (rightStr.length() > 0) {
					truncatable = isPrime(Integer.parseInt(rightStr));
					rightStr = rightStr.substring(0, rightStr.length() - 1);
				} else {
					break;
				}
			}
		}
		return truncatable;
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
