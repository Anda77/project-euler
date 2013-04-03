package com.walshcorp.projecteuler;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n n/2 (n is even) n 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence: 13 40 20 10 5 16 8 4 2 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem), it
 * is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * @author martin
 * 
 */
public class Problem14_LongestCollatzSequence implements ProblemInterface {
	@Override
	public void solve() {
		int longestLength = -1;
		int magicNumber = -1;
		for (int i = 999999; i > 0; i--) {
			// Solve length:
			int length = 1;
			long num = i;
			while (num != 1 && num > 0) {
				num = collatz(num);
				length += 1;
			}

			if (length > longestLength) {
				longestLength = length;
				magicNumber = i;
			}
		}
		System.out.println("Problem 14: " + magicNumber);
	}

	private long collatz(long n) {
		long collNum = 0;
		if (n % 2 == 0) {
			// Even
			collNum = n / 2;
		} else {
			// Odd
			collNum = 3 * n + 1;
		}
		return collNum;
	}
}
