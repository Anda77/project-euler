package com.walshcorp.projecteuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a != b, then a
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * @author martin
 * 
 */
public class Problem21_AmicableNumbers implements ProblemInterface {

	@Override
	public void solve() {
		int sum = 0;
		Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		for (int i = 1; i < 10000; i++) {
			int dOfI = sumDivisiors(i);
			if (i != dOfI) {
				numbers.put(i, sumDivisiors(i));
			}
		}
		for (int i = 1; i < 10000; i++) {
			// d(I) = J for d(J) = I
			// => d(d(I)) = I
			try {
				if (numbers.get(numbers.get(i)) == i) {
					sum += i;
				}
			} catch (NullPointerException e) {

			}
		}
		System.out.println("Problem 21: " + sum);
	}

	private int sumDivisiors(int num) {
		int sum = 0;
		List<Integer> divisors = getDivisors(num);
		for (Integer i : divisors) {
			sum += i;
		}
		return sum;
	}

	private List<Integer> getDivisors(int num) {
		List<Integer> divisors = new ArrayList<Integer>();
		int limit = num / 2;
		for (int i = 1; i <= limit; i++) {
			if (num % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}
}
