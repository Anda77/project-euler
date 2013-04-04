package com.walshcorp.projecteuler;

/**
 * An irrational decimal fraction is created by concatenating the positive
 * integers:<br />
 * <br />
 * 0.123456789101112131415161718192021...<br />
 * <br />
 * It can be seen that the 12th digit of the fractional part is 1.<br />
 * <br />
 * If dn represents the nth digit of the fractional part, find the value of the
 * following expression.<br />
 * <br />
 * d1 x d10 x d100 x d1000 x d10000 x d100000 x d1000000
 * 
 * @author martin
 * 
 */
public class Problem40_ChampernownesConstant implements ProblemInterface {
	@Override
	public void solve() {
		String str = buildString();
		int product = d(str, 1) * d(str, 10) * d(str, 100) * d(str, 1000)
				* d(str, 10000) * d(str, 100000) * d(str, 1000000);
		System.out.println("Problem 40: " + product);
	}

	private int d(String str, int position) {
		return Integer.parseInt("" + str.charAt(position - 1));
	}

	private String buildString() {
		StringBuilder builder = new StringBuilder(1000000);
		int i = 1;
		while (builder.capacity() <= 1000000) {
			builder.append(i);
			i++;
		}
		return builder.toString();
	}
}
