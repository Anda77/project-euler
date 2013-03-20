package com.walshcorp.projecteuler;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a
 * 5 by 5 spiral is formed as follows:<br />
 * <br />
 * 21 22 23 24 25<br />
 * 20 7 8 9 10<br />
 * 19 6 1 2 11<br />
 * 18 5 4 3 12<br />
 * 17 16 15 14 13<br />
 * <br />
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 * formed in the same way?
 * 
 * @author martin
 * 
 */
public class Problem28_NumberDiagonalSpirals implements ProblemInterface {

	@Override
	public void solve() {
		int sum = 1;

		for (int n = 3; n <= 1001; n += 2) {
			// RHS Diagonal Forward: n = 3,5,7,9, ... 1001
			// RHS Diagonal Forward = n^2
			sum += (n * n);

			// RHS Diagonal Backward: n = 3,5,7,9, ... 1001
			// RHS Diagonal Backward Limit = 1001*1001
			// RHS Diagonal Backward = (n-2)^2 + (n-1)
			sum += ((n - 2) * (n - 2) + (n - 1));

			// LHS Diagonal Forward: n = 3,5,7,9, ... 1001
			// LHS Diagonal Forward Limit = 1001*1001
			// LHS Diagonal Forward = (n-2)^2 + 2(n-1)
			sum += ((n - 2) * (n - 2) + 2 * (n - 1));

			// LHS Diagonal Backward: n = 3,5,7,9, ... 1001
			// LHS Diagonal Backward Limit = 1001*1001
			// LHS Diagonal Backward = (n-2)^2 + 3(n-1)
			sum += ((n - 2) * (n - 2) + 3 * (n - 1));
		}
		System.out.println("Problem 28: " + sum);
	}
}
