package com.walshcorp.projecteuler;

import java.text.NumberFormat;

/**
 * Starting in the top left corner of a 2x2 grid, and only being able to move to
 * the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * 
 * How many such routes are there through a 20x20 grid?
 * 
 * @author martin
 * 
 */
public class Problem15_LatticePaths implements ProblemInterface {
	@Override
	public void solve() {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		System.out.println("Problem 15: " + nf.format(combination(40, 20)));
	}

	private static double combination(int n, int m) {
		return (factorial(n) / (factorial(m) * factorial(n - m)));
	}

	private static double factorial(int n) {
		double ans = 1;
		if (n > 1) {
			ans = ans * factorial(n - 1);
			ans = ans * n;
		}

		return ans;
	}
}
