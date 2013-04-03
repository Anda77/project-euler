package com.walshcorp.projecteuler;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:<br />
 * 192 x 1 = 192<br />
 * 192 x 2 = 384<br />
 * 192 x 3 = 576<br />
 * <br />
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We
 * will call 192384576 the concatenated product of 192 and (1,2,3)<br />
 * <br />
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4,
 * and 5, giving the pandigital, 918273645, which is the concatenated product of
 * 9 and (1,2,3,4,5).<br />
 * <br />
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as
 * the concatenated product of an integer with (1,2, ... , n) where n > 1?
 * 
 * @author martin
 * 
 */
public class Problem38_PandigitalMultiples implements ProblemInterface {
	@Override
	public void solve() {
		int num = -1;

		// 1. To be the largest number, it must start with 9.
		// 2. The pandigital number must be a formed from a number starting with
		// 9 as 1 is the first multiplier.
		// 3. By inspection we need a four digit number, which when multipled by
		// 1 and 2 and concated will form a 4 + 5 = 9 digit number.

		// This will give a number of the form 9 _ _ _ 1 8 _ _ _ when multiplied
		// by 1 and 2 and concatenated.
		// Smaller numbers, ie 900 will need to be multipled by 1,2,3 giving an
		// 11 digit number.
		// Larger numbers ie 90000 when multiplied by 1 and 2 give 11 digit
		// numbers also.

		for (int i = 9000; i <= 9999; i++) {
			String concatStr = "";
			int n = 1;
			while (concatStr.length() < 9) {
				int product = i * n;
				concatStr += product;
				n++;
			}

			if (isPandigitalNineDigitNumber(concatStr)) {
				int pdn = Integer.parseInt(concatStr);
				if (pdn > num) {
					num = pdn;
				}
			}
		}
		System.out.println("Problem 38: " + num);
	}

	private boolean isPandigitalNineDigitNumber(String number) {
		boolean panDigital = true;
		if (number.length() == 9) {
			for (int i = 1; i <= 9; i++) {
				if (!number.contains("" + i)) {
					panDigital = false;
					break;
				}
			}
		} else {
			panDigital = false;
		}
		return panDigital;
	}
}
