package com.walshcorp.projecteuler;

import java.math.BigInteger;
import java.text.NumberFormat;

/**
 * n! means n x (n - 1) x ... x 3 x 2 x 1
 * 
 * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * @author martin
 * 
 */
public class Problem20_FactorialDigitSum implements ProblemInterface {

	@Override
	public void solve() {
		int sum = 0;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		BigInteger number = factorial(100);
		String chars = nf.format(number);
		chars = chars.replace("0", "");
		for (int i = 0; i < chars.length(); i++) {
			sum += Integer.parseInt("" + chars.charAt(i));
		}
		System.out.println("Problem 20: " + sum);

	}

	private BigInteger factorial(int n) {
		BigInteger ans = new BigInteger("1");
		if (n > 1) {
			ans = ans.multiply(factorial(n - 1));
			ans = ans.multiply(new BigInteger("" + n));
		}

		return ans;
	}
}
