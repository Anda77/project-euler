package com.walshcorp.projecteuler;

import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 * @author martin
 * 
 */
public class Problem16_PowerDigitSum implements ProblemInterface {
	@Override
	public void solve() {
		BigInteger num = new BigInteger("2").pow(1000);
		int ans = 0;

		String buffer = String.valueOf(num);

		for (int i = 0; i < buffer.length(); i++) {
			ans += Integer.parseInt("" + buffer.charAt(i));
		}
		System.out.println("Problem 16: " + ans);
	}
}
