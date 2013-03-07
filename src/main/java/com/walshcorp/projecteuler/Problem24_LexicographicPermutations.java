package com.walshcorp.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
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
		String numbers = "0123456789";

		List<String> permutations = permutations(numbers);
		Collections.sort(permutations);
		String millionth = permutations.get(999999);

		System.out.println("Problem 24: " + millionth);
	}

	private List<String> permutations(String word) {
		List<String> returnVal = new ArrayList<String>();
		if (word.length() > 1) {
			char character = word.charAt(0);
			for (String subPermute : permutations(word.substring(1))) {
				for (int index = 0; index <= subPermute.length(); index++) {
					String pre = subPermute.substring(0, index);
					String post = subPermute.substring(index);

					if (post.contains("" + character)) {
						continue;
					}
					returnVal.add(pre + character + post);
				}

			}
		} else {
			returnVal.add(word);
		}
		return returnVal;
	}
}
