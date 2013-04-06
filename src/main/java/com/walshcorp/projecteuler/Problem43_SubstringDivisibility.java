package com.walshcorp.projecteuler;

import java.text.NumberFormat;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up
 * of each of the digits 0 to 9 in some order, but it also has a rather
 * interesting sub-string divisibility property.<br />
 * <br />
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note
 * the following:<br />
 * d2d3d4=406 is divisible by 2<br />
 * d3d4d5=063 is divisible by 3<br />
 * d4d5d6=635 is divisible by 5<br />
 * d5d6d7=357 is divisible by 7<br />
 * d6d7d8=572 is divisible by 11<br />
 * d7d8d9=728 is divisible by 13<br />
 * d8d9d10=289 is divisible by 17<br />
 * 
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 * 
 * @author martin
 * 
 */
public class Problem43_SubstringDivisibility implements ProblemInterface {
	private int[] panDigitalNumber = new int[10];
	int[] divisors = { 2, 3, 5, 7, 11, 13, 17 };

	@Override
	public void solve() {
		// 9*9! combinations for valid pandigital numbers:
		double sum = 0D;
		for (int d1 = 1; d1 <= 9; d1++) {
			panDigitalNumber[0] = d1;
			sum += getSum(1);
		}

		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		System.out.println("Problem 43: " + nf.format(sum));
	}

	private double getSum(int index) {
		double sum = 0D;
		for (int i = 0; i <= 9; i++) {
			// Check if the digit can be used:
			if (!isTaken(i, panDigitalNumber, index)) {
				panDigitalNumber[index] = i;
				// Check if the sub-number can be divided by the applicable
				// prime:
				if (index < 3
						|| isDivisible(index - 2, panDigitalNumber,
								divisors[index - 3])) {
					if (index == 9) {
						// Add the value to the sum:
						sum = makePandigitalNumber(panDigitalNumber);
					} else {
						// Continue checking:
						sum += getSum(index + 1);
					}
				}
			}
		}
		return sum;
	}

	/**
	 * Checks whether the given digit has already been used.
	 * 
	 * @param ln
	 *            Digit to check
	 * @param number
	 *            Number Array.
	 * @param endIndex
	 *            upperBound limit
	 * @return
	 */
	private boolean isTaken(int ln, int[] number, int endIndex) {
		boolean taken = false;
		for (int i = 0; i < endIndex; i++) {
			if (ln == number[i]) {
				taken = true;
				break;
			}
		}
		return taken;
	}

	/**
	 * Constructs a three digit number from the given array and tests the
	 * divisors.
	 * 
	 * @param startIndex
	 * @param numArray
	 * @param divisors
	 * @return
	 */
	private boolean isDivisible(int startIndex, int[] numArray, int divisor) {
		int number = numArray[startIndex] * 100 + numArray[startIndex + 1] * 10
				+ numArray[startIndex + 2];

		return (number % divisor == 0);
	}

	/**
	 * Converts a digits int[] to a double
	 * 
	 * @param numArray
	 * @return
	 */
	private double makePandigitalNumber(int[] numArray) {
		double num = 0;

		double multiplier = 1;
		int len = numArray.length;

		for (int i = len - 1; i >= 0; i--) {
			num += (double) numArray[i] * multiplier;
			multiplier *= 10;
		}

		return num;
	}
}
