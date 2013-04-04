package com.walshcorp.projecteuler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class for parsing problem data.
 * 
 * @author martin
 * 
 */
public class Utilities {
	public static InputStream loadFileFromResources(String fileName) {
		return Utilities.class.getClassLoader().getResourceAsStream(fileName);
	}

	public static List<Integer> readFileAsListOfInteger(String fileName) {
		List<Integer> numbers = new ArrayList<Integer>();

		Scanner scanner = new Scanner(loadFileFromResources(fileName));

		while (scanner.hasNext()) {
			String number = scanner.next();
			numbers.add(Integer.parseInt(number));

		}
		scanner.close();

		return numbers;
	}

	public static List<Double> readFileAsListOfDouble(String fileName) {
		List<Double> numbers = new ArrayList<Double>();

		Scanner scanner = new Scanner(loadFileFromResources(fileName));

		while (scanner.hasNext()) {
			String number = scanner.next();
			numbers.add(Double.parseDouble(number));

		}
		scanner.close();

		return numbers;
	}

	public static List<List<Integer>> readFileAsListOfList(String fileName) {
		List<List<Integer>> twoDimensionalList = new ArrayList<List<Integer>>();

		Scanner scanner = new Scanner(loadFileFromResources(fileName));
		scanner.useDelimiter("\\n");
		while (scanner.hasNext()) {
			String numbers = scanner.next();
			numbers = numbers.trim();
			String[] numberArray = numbers.split("\\s+");

			List<Integer> row = new ArrayList<Integer>();
			for (int i = 0; i < numberArray.length; i++) {
				row.add(Integer.parseInt(numberArray[i]));
			}
			twoDimensionalList.add(row);
		}
		scanner.close();
		return twoDimensionalList;
	}

	public static int[][] readFileAs2DArray(String fileName) {
		List<int[]> tempList = new ArrayList<int[]>();

		Scanner scanner = new Scanner(loadFileFromResources(fileName));
		scanner.useDelimiter("\\n");
		while (scanner.hasNext()) {
			String numbers = scanner.next();
			numbers = numbers.trim();
			String[] numberArray = numbers.split("\\s+");

			int[] row = new int[numberArray.length];
			for (int i = 0; i < numberArray.length; i++) {
				row[i] = Integer.parseInt(numberArray[i]);
			}
			tempList.add(row);
		}
		scanner.close();

		int[][] twoD = new int[tempList.size()][];
		for (int i = 0; i < tempList.size(); i++) {
			twoD[i] = tempList.get(i);
		}

		return twoD;
	}

	public static List<String> readFileAsListOfString(String fileName) {
		List<String> returnList = new ArrayList<String>();
		Scanner scanner = new Scanner(loadFileFromResources(fileName));
		scanner.useDelimiter("\\n");

		while (scanner.hasNext()) {
			String line = scanner.next();
			String[] words = line.split(",");

			for (String word : words) {
				returnList.add(word.replace("\"", "").trim());
			}
		}
		return returnList;
	}
}
