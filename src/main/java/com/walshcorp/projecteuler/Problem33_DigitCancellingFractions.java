package com.walshcorp.projecteuler;

/**
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician
 * in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which
 * is correct, is obtained by cancelling the 9s.<br />
 * <br />
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.<br />
 * <br />
 * There are exactly four non-trivial examples of this type of fraction, less
 * than one in value, and containing two digits in the numerator and
 * denominator.<br />
 * <br />
 * If the product of these four fractions is given in its lowest common terms,
 * find the value of the denominator.
 * 
 * @author martin
 * 
 */
public class Problem33_DigitCancellingFractions implements ProblemInterface {
	private int multipliedNumerators = 1;
	private int multipliedDenominators = 1;

	@Override
	public void solve() {
		// Both parts of fraction are between 10 and 99.
		// Fractions that have either part as a unit of 10 are to be
		// excluded.
		for (int num = 10; num < 100; num++) {
			if (!isUnitOfTen(num)) {
				// Number less than 1:
				for (int denom = num + 1; denom < 100; denom++) {
					if (!isUnitOfTen(denom)) {
						// Check if the numbers can be reduced:
						if (reducesToSameValue(num, denom)) {
							// Multiply numerators and denominators to get
							// product of fraction.
							multipliedNumerators *= num;
							multipliedDenominators *= denom;
						}
					}
				}
			}
		}
		// Reduce fraction to smallest form and print denominator:
		System.out.println("Problem 33: "
				+ smallestFormDenominator(multipliedNumerators,
						multipliedDenominators));
	}

	/**
	 * Checks whether the given number is a multiple of 10.
	 * 
	 * @param number
	 * @return
	 */
	private boolean isUnitOfTen(int number) {
		return number % 10 == 0;
	}

	/**
	 * Checks whether the number is the special case described by the problem.
	 * 
	 * @param numerator
	 * @param denominator
	 * @return
	 */
	private boolean reducesToSameValue(int numerator, int denominator) {
		boolean reduces = false;

		String emptyStr = "";
		String numStr = emptyStr + numerator;
		String denomStr = emptyStr + denominator;
		double fraction = getDecimalValue(numerator, denominator);

		for (int i = 1; i <= 9; i++) {
			String iStr = emptyStr + i;
			if (numStr.contains(iStr) && denomStr.contains(iStr)) {
				numStr = numStr.replace(iStr, emptyStr);
				if (!numStr.isEmpty()) {
					denomStr = denomStr.replace(iStr, emptyStr);
					if (!denomStr.isEmpty()) {
						int newNum = Integer.parseInt(numStr);
						int newDenom = Integer.parseInt(denomStr);
						double testFraction = getDecimalValue(newNum, newDenom);
						if (fraction == testFraction) {
							reduces = true;
							break;
						}
					}
				}
			}
		}
		return reduces;
	}

	private double getDecimalValue(int numerator, int denominator) {
		return ((double) numerator) / ((double) denominator);
	}

	/**
	 * Returns the denominator for the smallest form of the given fraction,
	 * which may or may not be the given denominator.
	 * 
	 * @param numerator
	 * @param denominator
	 * @return
	 */
	private int smallestFormDenominator(int numerator, int denominator) {
		int smallestDenom = denominator;
		for (int i = numerator; i > 1; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				smallestDenom = denominator / i;
				break;
			}
		}
		return smallestDenom;
	}
}
