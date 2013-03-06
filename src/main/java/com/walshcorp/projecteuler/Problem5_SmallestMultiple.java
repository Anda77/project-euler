package com.walshcorp.projecteuler;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * @author martin
 * 
 */
public class Problem5_SmallestMultiple implements ProblemInterface {
	@Override
	public void solve() {
		int number = 0;
		boolean numFound = false;
		while (!numFound) {
			number++;
			boolean ok = true;
			for (int n = 20; n >= 2; n--) {
				if (number % n != 0) {
					ok = false;
					break;
				}
			}
			numFound = ok;
		}
		System.out.println("Problem 5: " + number);
	}
}
