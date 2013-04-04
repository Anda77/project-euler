package com.walshcorp.projecteuler;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
 * also prime.<br />
 * <br />
 * What is the largest n-digit pandigital prime that exists?
 * 
 * @author martin
 * 
 */
public class Problem41_PandigitalPrime implements ProblemInterface {
	@Override
	public void solve() {
		// Upper bound limit:
		// Largest pandigital number that can have possibility of being prime is
		// that where (1+2+...+n) %3 == 1; This excludes n=9 and n=8;
		int i = 7654321;

		// Lower Bound Limit: 12 as 11 is the next smallest prime number, and is
		// not pandigital...
		while (i > 12) {
			if (isPandigitalNumber("" + i) && isPrime(i)) {
				break;
			}
			// Not including 2, we can assume that all other primes are odd:
			i -= 2;
		}
		System.out.println("Problem 41: " + i);
	}

	private boolean isPandigitalNumber(String number) {
		boolean panDigital = true;
		int length = number.length();

		for (int i = 1; i <= length; i++) {
			if (!number.contains("" + i)) {
				panDigital = false;
				break;
			}
		}

		return panDigital;
	}

	private boolean isPrime(int number) {
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
		return prime;
	}
}
