package com.walshcorp.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 * 
 * @author martin
 * 
 */
public class Problem24_LexicographicPermutations implements ProblemInterface {

	@Override
	public void solve() {
		List<String> numberList = new ArrayList<String>();
		numberList.add("0");
		numberList.add("1");
		numberList.add("2");
		numberList.add("3");
		numberList.add("4");
		numberList.add("5");
		numberList.add("6");
		numberList.add("7");
		numberList.add("8");
		numberList.add("9");

		// Millionth index = 999999;

		// Factorial reduction:
		// 999999 = 2 * 9! + 274239
		// = 2*9! + 6*8! + 32319
		// = 2*9! + 6*8! + 6*7! + 2079
		// = 2*9! + 6*8! + 6*7! + 2*6! + 639
		// = 2*9! + 6*8! + 6*7! + 2*6! + 5*5! + 39
		// = 2*9! + 6*8! + 6*7! + 2*6! + 5*5! + 1*4! + 15
		// = 2*9! + 6*8! + 6*7! + 2*6! + 5*5! + 1*4! + 2*3! + 3
		// = 2*9! + 6*8! + 6*7! + 2*6! + 5*5! + 1*4! + 2*3! + 1*2! + 1*1! + 0
		// = 2*9! + 6*8! + 6*7! + 2*6! + 5*5! + 1*4! + 2*3! + 1*2! + 1*1! + 0+0!

		// Multipliers = 2,6,6,2,5,1,2,1,1,0
		// Using these indices and removing the positions from the List, the
		// millionth permutation can be constructed:

		String millionth = "";
		millionth += numberList.remove(2);
		millionth += numberList.remove(6);
		millionth += numberList.remove(6);
		millionth += numberList.remove(2);
		millionth += numberList.remove(5);
		millionth += numberList.remove(1);
		millionth += numberList.remove(2);
		millionth += numberList.remove(1);
		millionth += numberList.remove(1);
		millionth += numberList.remove(0);

		System.out.println("Problem 24: " + millionth);
	}
}
