package com.walshcorp.projecteuler;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * The Fibonacci sequence is defined by the recurrence relation: Fn = Fn-1 +
 * Fn-2, where F1 = 1 and F2 = 1.<br />
 * 
 * Hence the first 12 terms will be:<br />
 * F1 = 1<br />
 * F2 = 1<br />
 * F3 = 2<br />
 * F4 = 3<br />
 * F5 = 5<br />
 * F6 = 8<br />
 * F7 = 13<br />
 * F8 = 21<br />
 * F9 = 34<br />
 * F10 = 55<br />
 * F11 = 89<br />
 * F12 = 144<br />
 * 
 * The 12th term, F12, is the first term to contain three digits.
 * 
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 * @author martin
 * 
 */
public class Problem25_1000DigitFibonacciNumber implements ProblemInterface {
	private Map<Integer, BigInteger> fibNumbers = new HashMap<Integer, BigInteger>();

	@Override
	public void solve() {
		int number = 1;
		boolean conditionMet = false;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		String chars = null;
		while (!conditionMet) {
			number++;
			BigInteger fibNum = Fibonacci(number);
			chars = nf.format(fibNum);
			if (chars.length() >= 1000) {
				conditionMet = true;
			}
		}
		System.out.println("Problem 25: " + number);
	}

	/**
	 * Returns the fibonacci number for the given position in the sequence.
	 * 
	 * @param number
	 * @return
	 */
	private BigInteger Fibonacci(int number) {
		BigInteger fib = null;
		if (fibNumbers.containsKey(number)) {
			fib = fibNumbers.get(number);
		} else {
			if (number <= 2) {
				fib = new BigInteger("1");
			} else {
				fib = Fibonacci(number - 1).add(Fibonacci(number - 2));
			}
			fibNumbers.put(number, fib);
		}
		return fib;
	}
}
