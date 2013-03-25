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
		int combinations = -1; // 0 if 200 not included, 1 if 200 included...

		// How many ways can 200 be made given units of 100, 50, 20, 10,
		// 5, 2 and 1? (Also 200?)

		// Need to find combinations...
		// What is formula/method for this operation?

		// DP solution... O(n^2) or O(n log n) complexity...
		System.out.println("Problem 31: " + combinations);
	}
}
