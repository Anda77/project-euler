package com.walshcorp.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author martin
 * 
 */
public class Problem4_LargestPalindromeProduct implements ProblemInterface {
	@Override
	public void solve() {
		List<String> palindromes = new ArrayList<String>();
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				int result = i * j;
				String checkStr = "" + result;
				if (checkPalindrome(checkStr)) {
					if (!palindromes.contains(checkStr)) {
						palindromes.add(checkStr);
					}
				}
			}
		}
		Collections.sort(palindromes);
		System.out.println("Problem 4: "
				+ palindromes.get(palindromes.size() - 1));
	}

	/**
	 * Checks whether a string is a Palindrome
	 * 
	 * @param str
	 * @return
	 */
	private static boolean checkPalindrome(String str) {
		boolean isPalindrome = true;
		int len = str.length();
		if (len % 2 == 1) {
			isPalindrome = false;
		} else {
			int mid = (int) Math.ceil((double) (len / 2));

			for (int i = 0; i < mid; i++) {
				if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
					isPalindrome = false;
					break;
				}
			}
		}

		return isPalindrome;
	}
}
