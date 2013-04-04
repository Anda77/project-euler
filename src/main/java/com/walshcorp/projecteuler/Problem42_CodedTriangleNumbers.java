package com.walshcorp.projecteuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1);
 * so the first ten triangle numbers are:<br />
 * <br />
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...<br />
 * <br />
 * By converting each letter in a word to a number corresponding to its
 * alphabetical position and adding these values we form a word value. For
 * example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value
 * is a triangle number then we shall call the word a triangle word.<br />
 * <br />
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file
 * containing nearly two-thousand common English words, how many are triangle
 * words?<br />
 * 
 * @author martin
 * 
 */
public class Problem42_CodedTriangleNumbers implements ProblemInterface {
	List<Integer> triangularNumbers = null;
	Map<Character, Integer> alphabet = null;

	@Override
	public void solve() {
		int triangleWords = 0;
		// Longest word in the english language, of Mary poppins fame is
		// "Supercalifragilisticexpialidocious" with 34 letters.
		// The highest value a letter word can have is 34 x 26 = 884.
		triangularNumbers = setupTriangularNumbers(884);
		alphabet = setupAlphabet();
		List<String> words = Utilities.readFileAsListOfString("Problem42_Res");

		for (String word : words) {
			if (isTriangleWord(word)) {
				triangleWords++;
			}
		}
		System.out.println("Problem 42: " + triangleWords);
	}

	private boolean isTriangleWord(String word) {
		int wordSum = 0;
		for (int i = 0; i < word.length(); i++) {
			wordSum += alphabet.get(word.charAt(i));
		}
		return triangularNumbers.contains(wordSum);
	}

	/**
	 * Generates a map of all the triangular numbers up to the given limit.
	 * 
	 * @param limit
	 * @return
	 */
	private List<Integer> setupTriangularNumbers(int limit) {
		List<Integer> tns = new ArrayList<Integer>();
		int i = 0;
		boolean limitMetOrExceeded = false;
		while (!limitMetOrExceeded) {
			int tn = (i * (i + 1)) / 2;
			limitMetOrExceeded = (tn >= limit);
			tns.add(tn);
			i++;
		}
		return tns;
	}

	/**
	 * Generates a map of characters and there positions in the alphabet.
	 * 
	 * @return
	 */
	private Map<Character, Integer> setupAlphabet() {
		Map<Character, Integer> ab = new HashMap<Character, Integer>();
		ab.put('A', 1);
		ab.put('B', 2);
		ab.put('C', 3);
		ab.put('D', 4);
		ab.put('E', 5);
		ab.put('F', 6);
		ab.put('G', 7);
		ab.put('H', 8);
		ab.put('I', 9);
		ab.put('J', 10);
		ab.put('K', 11);
		ab.put('L', 12);
		ab.put('M', 13);
		ab.put('N', 14);
		ab.put('O', 15);
		ab.put('P', 16);
		ab.put('Q', 17);
		ab.put('R', 18);
		ab.put('S', 19);
		ab.put('T', 20);
		ab.put('U', 21);
		ab.put('V', 22);
		ab.put('W', 23);
		ab.put('X', 24);
		ab.put('Y', 25);
		ab.put('Z', 26);

		return ab;
	}
}
