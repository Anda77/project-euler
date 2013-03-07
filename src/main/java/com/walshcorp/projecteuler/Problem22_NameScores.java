package com.walshcorp.projecteuler;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name
 * score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 x 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * @author martin
 * 
 */
public class Problem22_NameScores implements ProblemInterface {

	@Override
	public void solve() {
		int sum = 0;

		Map<String, Integer> alphabet = new HashMap<String, Integer>();
		alphabet.put("A", 1);
		alphabet.put("B", 2);
		alphabet.put("C", 3);
		alphabet.put("D", 4);
		alphabet.put("E", 5);
		alphabet.put("F", 6);
		alphabet.put("G", 7);
		alphabet.put("H", 8);
		alphabet.put("I", 9);
		alphabet.put("J", 10);
		alphabet.put("K", 11);
		alphabet.put("L", 12);
		alphabet.put("M", 13);
		alphabet.put("N", 14);
		alphabet.put("O", 15);
		alphabet.put("P", 16);
		alphabet.put("Q", 17);
		alphabet.put("R", 18);
		alphabet.put("S", 19);
		alphabet.put("T", 20);
		alphabet.put("U", 21);
		alphabet.put("V", 22);
		alphabet.put("W", 23);
		alphabet.put("X", 24);
		alphabet.put("Y", 25);
		alphabet.put("Z", 26);

		String fileContents = null;
		Scanner scanner = new Scanner(
				Utilities.loadFileFromResources("Problem22_Res"));
		scanner.useDelimiter("\\n");
		while (scanner.hasNext()) {
			fileContents = scanner.next();
		}
		scanner.close();

		fileContents = fileContents.replace("\"", "");

		String[] names = fileContents.split(",");
		List<String> namesList = Arrays.asList(names);

		Collections.sort(namesList);
		for (int i = 0; i < namesList.size(); i++) {
			String name = namesList.get(i);
			int nameSum = 0;
			for (int c = 0; c < name.length(); c++) {
				nameSum += alphabet.get("" + name.charAt(c));
			}
			sum += (nameSum * (i + 1));
		}

		System.out.println("Problem 22: " + sum);
	}

}
