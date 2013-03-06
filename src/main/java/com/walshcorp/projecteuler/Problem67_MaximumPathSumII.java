package com.walshcorp.projecteuler;

public class Problem67_MaximumPathSumII implements ProblemInterface {
	private int maxSum;

	@Override
	public void solve() {
		maxSum = sumSmart(Utilities.readFileAs2DArray("Problem67_Res"));
		System.out.println("Problem 67: " + maxSum);
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
