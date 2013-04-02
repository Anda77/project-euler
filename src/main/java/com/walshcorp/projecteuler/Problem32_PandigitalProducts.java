package com.walshcorp.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the
 * digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1
 * through 5 pandigital.<br />
 * <br />
 * The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing
 * multiplicand, multiplier, and product is 1 through 9 pandigital.<br />
 * <br />
 * 
 * Find the sum of all products whose multiplicand/multiplier/product identity
 * can be written as a 1 through 9 pandigital. <br />
 * HINT: Some products can be obtained in more than one way so be sure to only
 * include it once in your sum.
 * 
 * @author martin
 * 
 */
public class Problem32_PandigitalProducts implements ProblemInterface {
	private List<Integer> products = new ArrayList<Integer>();

	@Override
	public void solve() {
		// To make up nine digits between multiplicand, multiplier and product,
		// the only valid solutions are:
		// 1. A 1 digit number multiplier by a 4 digit number giving a 4 digit
		// number.
		// 2. A 2 digit number multiplier by a 3 digit number giving a 4 digit
		// number
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 10000; j++) {
				int product = i * j;
				if (isPanDigital(i, j, product)) {
					addProduct(product);
				}
			}
		}
		System.out.println("Problem 32: " + getSum());
	}

	private boolean isPanDigital(int multiplicand, int multiplier, int product) {
		boolean panDigital = true;
		String str = "" + multiplicand + multiplier + product;
		int length = str.length();
		if (length == 9) {
			// Reduce string and check lengths:
			for (int i = 1; i < 10; i++) {
				str = str.replace("" + i, "");
				int newLength = str.length();
				if ((length - newLength) != 1) {
					panDigital = false;
					break;
				}
				length = newLength;
			}
		} else {
			panDigital = false;
		}

		return panDigital;
	}

	private void addProduct(int product) {
		if (!products.contains(product)) {
			products.add(product);
		}
	}

	private Integer getSum() {
		int sum = 0;
		for (int i : products) {
			sum += i;
		}
		return sum;
	}
}
