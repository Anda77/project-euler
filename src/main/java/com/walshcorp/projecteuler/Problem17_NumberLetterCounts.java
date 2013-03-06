package com.walshcorp.projecteuler;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * 
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 * 
 * @author martin
 * 
 */
public class Problem17_NumberLetterCounts implements ProblemInterface {
	private int numberOfLetters = 0;
	private SortedMap<Integer, Integer> numberMap = null;
	Integer[] keys = null;

	@Override
	public void solve() {
		numberOfLetters = 0;

		// Map< #, Number of Letters in Word >
		numberMap = new TreeMap<Integer, Integer>();

		// One to Nine:
		numberMap.put(1, 3); // One
		numberMap.put(2, 3); // Two
		numberMap.put(3, 5); // Three
		numberMap.put(4, 4); // Four
		numberMap.put(5, 4); // Five
		numberMap.put(6, 3); // Six
		numberMap.put(7, 5); // Seven
		numberMap.put(8, 5); // Eight
		numberMap.put(9, 4); // Nine
		numberMap.put(10, 3); // Ten

		// Teens:
		numberMap.put(11, 6); // Eleven
		numberMap.put(12, 6); // Twelve
		numberMap.put(13, 8); // Thirteen
		numberMap.put(14, 8); // Fourteen
		numberMap.put(15, 7); // Fifteen
		numberMap.put(16, 7); // Sixteen
		numberMap.put(17, 9); // Seventeen
		numberMap.put(18, 8); // Eighteen
		numberMap.put(19, 8); // Nineteen

		// Units of Ten:
		numberMap.put(20, 6); // Twenty
		numberMap.put(30, 6); // Thirty
		numberMap.put(40, 5); // Forty
		numberMap.put(50, 5); // Fifty
		numberMap.put(60, 5); // Sixty
		numberMap.put(70, 7); // Seventy
		numberMap.put(80, 6); // Eighty
		numberMap.put(90, 6); // Ninety

		// Hundred:
		numberMap.put(100, 7);

		keys = numberMap.keySet().toArray(new Integer[0]);

		for (int i = 1; i <= 1000; i++) {
			if (i < 100) {
				addLength(i);
			} else if (i < 1000) {
				// Check number of Hundreds
				int hundredMultiplier = 0;
				for (int j = 9; j > 0; j--) {
					if ((i - j * 100) >= 0) {
						hundredMultiplier = j;
						break;
					}
				}

				// Hundreds:
				numberOfLetters += numberMap.get(hundredMultiplier);
				numberOfLetters += numberMap.get(100);
				;

				// Remainder:
				int remainder = i - hundredMultiplier * 100;

				if (remainder > 0) {
					addLength(remainder);
					// Provide for word 'and'
					numberOfLetters += 3;
				}
			} else {
				numberOfLetters += 3; // One
				numberOfLetters += 8; // Thousand
			}
		}

		System.out.println("Problem 17: " + numberOfLetters);
	}

	/**
	 * Call on numbers less than 100 only!
	 * 
	 * @param i
	 */
	private void addLength(int i) {
		if (i < 100) {
			Integer value = numberMap.get(i);
			if (value != null) {
				// Stored value:
				numberOfLetters += value;
			} else {
				// Numbers not ending in zero:
				if (i > 20) {
					int goodIndex = -1;
					for (int j = keys.length - 1; j > 0; j--) {
						if ((i - keys[j] > 0)) {
							goodIndex = j;
							break;
						}
					}

					numberOfLetters += numberMap.get(keys[goodIndex]);

					// Remainder:
					numberOfLetters += numberMap.get(i - keys[goodIndex]);
				}
			}
		} else {
			System.out.println("ERROR *** Number must be less than 100: " + i);
		}
	}
}
