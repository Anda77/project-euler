package com.walshcorp.projecteuler;

import java.util.Arrays;

/**
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.<br />
 * <br />
 * Find the sum of all numbers, less than one million, which are palindromic in
 * base 10 and base 2.<br />
 * <br />
 * (Please note that the palindromic number, in either base, may not include
 * leading zeros.)
 * 
 * @author martin
 * 
 */
public class Problem36_DoubleBasePalindromes implements ProblemInterface {

	@Override
	public void solve() {
		int sum = 0;
		for (int i = 1; i < 1000000; i++) {
			if (isPalindrome("" + i)) {
				String bin = getBinaryRepresentation(i);
				if (!bin.startsWith("0") && isPalindrome(bin)) {
					sum += i;
				}
			}
		}

		System.out.println("Problem 36: " + sum);
	}

	private String getBinaryRepresentation(int n) {
		return Integer.toBinaryString(n);
	}

	private boolean isPalindrome(String str) {
		char[] chars = str.toCharArray();
		int len = chars.length;
		char[] reverse = new char[len];
		for (int i = 0; i < len; i++) {
			reverse[len - 1 - i] = chars[i];
		}
		return Arrays.equals(chars, reverse);
	}
}
