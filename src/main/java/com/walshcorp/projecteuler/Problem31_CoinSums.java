package com.walshcorp.projecteuler;

/**
 * In England the currency is made up of pound, £, and pence, p, and there are
 * eight coins in general circulation:<br />
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).<br />
 * <br />
 * It is possible to make £2 in the following way:<br />
 * 1 x £1 + 1 x 50p + 2 x 20p + 1 x 5p + 1 x 2p + 3 x 1p<br />
 * <br />
 * How many different ways can £2 be made using any number of coins?
 * 
 * @author martin
 * 
 */
public class Problem31_CoinSums implements ProblemInterface {
	@Override
	public void solve() {
		// How many ways can 200 be made given units of 100, 50, 20, 10,
		// 5, 2 and 1? (Also 200?)

		// Need to find number of combinations, not combinations themselves...
		// No need to store combinations.

		// DP solution... O(n^2) or O(n log n) complexity...

		// Algorithm:
		// Solve for ways all sums less than 200 can be made with 1p,
		// then 2p etc. As the larger coins are used, add the previously found
		// solutions.
		// Do this by referencing the solution for the sub problem: (current sum
		// - coin value) and adding it on.

		int sum = 200;
		int[] coinSizes = { 1, 2, 5, 10, 20, 50, 100, 200 };
		int[] combinations = new int[sum + 1];

		// Base case. Only 1 way to make 0, or everything has at least one
		// solution with pennies.
		combinations[0] = 1;

		for (int i = 0; i < coinSizes.length; i++) {
			for (int j = coinSizes[i]; j <= sum; j++) {
				combinations[j] += combinations[j - coinSizes[i]];
			}
		}

		System.out.println("Problem 31: " + combinations[200]);
	}
}