package com.walshcorp.projecteuler;

/**
 * Euler published the remarkable quadratic formula:<br />
 * 
 * n² + n + 41<br />
 * <br />
 * It turns out that the formula will produce 40 primes for the consecutive
 * values n = 0 to 39. However, when n = 40, 40² + 40 + 41 = 40(40 + 1) + 41 is
 * divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
 * divisible by 41.<br />
 * <br />
 * Using computers, the incredible formula n² + 79n + 1601 was discovered, which
 * produces 80 primes for the consecutive values n = 0 to 79. The product of the
 * coefficients, 79 and 1601, is 126479.<br />
 * <br />
 * Considering quadratics of the form:<br />
 * n² + an + b, where |a| < 1000 and |b| < 1000<br />
 * 
 * where |n| is the modulus/absolute value of n e.g. |11| = 11 and |-4| = 4 <br />
 * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 * 
 * @author martin
 * 
 */
public class Problem27_QuadraticPrimes implements ProblemInterface {

	@Override
	public void solve() {
		int storeA = -999;
		int storeB = -999;
		int maxPrimes = 0;
		int n = 0;
		for (int a = -999; a < 1000; a++) {
			for (int b = -999; b < 1000; b++) {
				n = -1;
				boolean prime = true;
				while (prime) {
					n++;
					int num = magicFormula(a, b, n);
					prime = isPrime(num);
				}
				if (n > maxPrimes) {
					maxPrimes = n;
					storeA = a;
					storeB = b;
				}
			}
		}
		int result = Math.abs(storeA * storeB);

		System.out.println("Problem 27: " + result);
	}

	/**
	 * Checks whether a number is prime.
	 * 
	 * @param number
	 * @return
	 */
	private boolean isPrime(int number) {
		boolean prime = true;
		if (number > 0) {
			double limit = Math.sqrt(number);
			if (number == 1) {
				prime = false;
			} else {
				for (int i = 2; i <= limit; i++) {
					if (number % i == 0) {
						prime = false;
						break;
					}
				}
			}
		} else {
			prime = false;
		}
		return prime;
	}

	/**
	 * Formula: n^2 + a*n + b
	 * 
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	private int magicFormula(int a, int b, int n) {
		return n * n + a * n + b;
	}
}
