package com.walshcorp.projecteuler;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.<br />
 * 
 * 3<br />
 * 7 4<br />
 * 2 4 6<br />
 * 8 5 9 3<br />
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom of the triangle below:<br />
 * 
 * 75<br />
 * 95 64<br />
 * 17 47 82<br />
 * 18 35 87 10<br />
 * 20 04 82 47 65<br />
 * 19 01 23 75 03 34<br />
 * 88 02 77 73 07 63 67<br />
 * 99 65 04 28 06 16 70 92<br />
 * 41 41 26 56 83 40 80 70 33<br />
 * 41 48 72 33 47 32 37 16 94 29<br />
 * 53 71 44 65 25 43 91 52 97 51 14<br />
 * 70 11 33 28 77 73 17 78 39 68 17 57<br />
 * 91 71 52 38 17 14 91 43 58 50 27 29 48<br />
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31<br />
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23<br />
 * 
 * @author martin
 * 
 */
public class Problem18_MaximumPathSumI implements ProblemInterface {
	private int maxSum = 0;
	private int maxRowIndex = 0;
	private int[][] numbersArray;

	@Override
	public void solve() {
		numbersArray = Utilities.readFileAs2DArray("Problem18_Res");

		maxRowIndex = numbersArray.length - 1;

		maxSum = sumBruteForce(0, 0);

		System.out.println("Problem 18: " + maxSum);
	}

	/**
	 * Brute force sum finder. Recursive and inefficient.
	 * 
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 */
	private int sumBruteForce(int rowIndex, int colIndex) {
		int runningSum = 0;
		int pathA = 0;
		int pathB = 0;

		if (rowIndex < maxRowIndex) {
			// Left Child:
			pathA += sumBruteForce(rowIndex + 1, colIndex);

			// Right Child:
			pathB += sumBruteForce(rowIndex + 1, colIndex + 1);

			// Only care about the larger number, not the route itself:
			if (pathA > pathB) {
				runningSum += pathA;
			} else {
				runningSum += pathB;
			}
		}
		// Add the parent value:
		runningSum += numbersArray[rowIndex][colIndex];

		return runningSum;
	}

	/**
	 * Solve the problem bottom-up<br />
	 * Overwrite the 'tree' as we go to save memory as it is not needed.
	 */
	private int sumSmart(int[][] numbers) {
		// Solve from bottom up:
		for (int i = numbers.length - 2; i >= 0; i--) {
			int[] row = numbers[i];
			int[] rowBelow = numbers[i + 1];

			// Check each sub triangle path:
			for (int j = 0; j < row.length; j++) {
				int leftChild = rowBelow[j];
				int rightChild = rowBelow[j + 1];

				// Add greater of left and right child to parent value.
				row[j] += Math.max(leftChild, rightChild);
			}
		}
		return numbers[0][0];
	}
}
