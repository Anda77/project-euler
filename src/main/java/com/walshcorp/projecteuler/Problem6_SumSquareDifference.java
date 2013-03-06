package com.walshcorp.projecteuler;

/**
 * The sum of the squares of the first ten natural numbers is, 12 + 22 + ... +
 * 102 = 385
 * 
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... +
 * 10)2 = 552 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * 
 * @author martin
 * 
 */
public class Problem6_SumSquareDifference implements ProblemInterface {
	@Override
	public void solve() {
		int sumSquare = 0;
		int squareSum = 0;
		int result = 0;
		for (int i = 1; i < 101; i++) {
			sumSquare += (i * i);
			squareSum += i;
		}
		squareSum = squareSum * squareSum;
		result = squareSum - sumSquare;
		System.out.println("Problem 6: " + result);
	}
}
