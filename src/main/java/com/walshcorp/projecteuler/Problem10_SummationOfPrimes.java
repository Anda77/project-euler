package com.walshcorp.projecteuler;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * @author martin
 * 
 */
public class Problem10_SummationOfPrimes implements ProblemInterface {
	@Override
	public void solve() {
		long sum = 0;
		for (int i = 0; i < 2000000; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		System.out.println("Problem 10: " + sum);
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
