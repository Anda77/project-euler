package com.walshcorp.projecteuler;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author martin
 * 
 */
public class Problem3_LargestPrimeFactor implements ProblemInterface {
	@Override
	public void solve() {
		int checkPrime = 2;
		double newNum = 600851475143D;
		String primes = "";

		// Check prime factor down to 1:
		while (newNum != 1) {
			// Check to see if checkPrime is a factor of newNum:
			if (newNum % checkPrime == 0) {
				// Add to string:
				primes += checkPrime;

				// Check for more factors:
				newNum = newNum / checkPrime;
				if (newNum != 1) {
					primes += ".";
				}
			} else {
				checkPrime++;
			}
		}

		if (newNum != 1) {
			primes += newNum;
		}

		System.out.println("Problem 3: " + primes);
	}
}
