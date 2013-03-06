package com.walshcorp.projecteuler;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * 
 * What is the 10001st prime number?
 * 
 * @author martin
 * 
 */
public class Problem7_10001stPrime implements ProblemInterface {
	@Override
	public void solve() {
		int counter = 1; // 2 is prime
		int num = 1;
		int prime = 0;
		while (counter < 10001) {
			if (isPrime(num)) {
				prime = num;
				counter++;
			}
			num += 2;
		}

		System.out.println("Problem 7: " + prime);
	}

	private static boolean isPrime(int number) {
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
