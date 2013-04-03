package com.walshcorp.projecteuler;

import java.text.NumberFormat;
import java.util.List;

/**
 * Work out the first ten digits of the sum of the following one-hundred
 * 50-digit numbers.
 * 
 * @author martin
 * 
 */
public class Problem13_LargeSum implements ProblemInterface {
	@Override
	public void solve() {
		List<Double> numbers = Utilities
				.readFileAsListOfDouble("Problem13_Res");
		;
		Double total = 0d;
		for (Double d : numbers) {
			total += d;
		}

		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		System.out.println("Problem 13: " + nf.format(total).substring(0, 10));
	}
}
