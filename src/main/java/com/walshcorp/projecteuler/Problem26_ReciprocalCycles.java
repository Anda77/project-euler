package com.walshcorp.projecteuler;

import java.util.HashSet;
import java.util.Set;

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:<br />
 * 1/2 = 0.5<br />
 * 1/3 = 0.(3)<br />
 * 1/4 = 0.25<br />
 * 1/5 = 0.2<br />
 * 1/6 = 0.1(6)<br />
 * 1/7 = 0.(142857)<br />
 * 1/8 = 0.125<br />
 * 1/9 = 0.(1)<br />
 * 1/10 = 0.1<br />
 * 
 * 
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be
 * seen that 1/7 has a 6-digit recurring cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 * 
 * @author martin
 * 
 */
public class Problem26_ReciprocalCycles implements ProblemInterface {
	@Override
	public void solve() {
		int max = 0;
		int maxd = 0;

		// 10^s = 10^(s+t) (mod d)
		// (10^s)/d has same remainder as (10^(s+t))/d

		for (int d = 1; d < 1000; d++) {
			Set<Integer> remainders = new HashSet<Integer>();
			int x = 1;
			int len = 0;
			while (x < d) {
				// Next Power:
				// x = (10^s)
				x *= 10;
			}
			while (x != 0) {
				if (remainders.contains(x)) {
					// Checked already:
					break;
				}
				remainders.add(x);

				while (x < d) {
					// Next Power:
					// x = 10^(s+t)
					x *= 10;
					len++; // t
				}
				// Modulus:
				x = x % d;
			}
			if (x != 0) {
				if (len > max) {
					maxd = d;
					max = len;
				}
			}
		}
		System.out.println("Problem 26: " + maxd);
	}
}
