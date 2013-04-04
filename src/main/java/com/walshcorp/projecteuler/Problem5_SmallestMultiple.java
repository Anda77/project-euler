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
		// Prime factorization:
		// 1=1, 2=2, 3=3, 4=2^2, 5=5, 6=2*3, 7=7, 8=2^3 ,9=3^2, 10=2*5, 11=11,
		// 12=2^2*3, 13=13, 14=2*7, 15=3*5, 16=2^4 ,17=17, 18=3^2*2, 19=19,
		// 20=2^2*5

		// To obtain answer, multiply the greatest power of each prime together:
		// 2^4 * 3^2 * 5 * 7 * 11 * 13 * 17 * 19

		int number = (int) (Math.pow(2, 4) * Math.pow(3, 2) * 5 * 7 * 11 * 13
				* 17 * 19);

		System.out.println("Problem 5: " + number);
	}
}
