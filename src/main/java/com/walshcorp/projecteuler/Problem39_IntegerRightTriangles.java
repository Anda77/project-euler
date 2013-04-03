package com.walshcorp.projecteuler;

/**
 * If p is the perimeter of a right angle triangle with integral length sides,
 * {a,b,c}, there are exactly three solutions for p = 120.<br />
 * <br />
 * {20,48,52}, {24,45,51}, {30,40,50}<br />
 * <br />
 * For which value of p <= 1000, is the number of solutions maximised?
 * 
 * @author martin
 * 
 */
public class Problem39_IntegerRightTriangles implements ProblemInterface {
	@Override
	public void solve() {
		int largestP = -1;
		int maxSolutions = 1;
		for (int p = 1; p <= 1000; p++) {
			int sol = getSolutions(p);
			if (sol > maxSolutions) {
				maxSolutions = sol;
				largestP = p;
			}
		}
		System.out.println("Problem 39: " + largestP);
	}

	private int getSolutions(double p) {
		// Add logic to get solutions for triangle:
		int solutions = 0;
		for (double opp = 1; opp < p; opp++) {
			double oppSq = opp * opp;
			for (double adj = 1; adj < (p - opp); adj++) {
				double hyp = Math.sqrt(oppSq + (adj * adj));
				if ((hyp + opp + adj) == p) {
					solutions++;
				}
			}
		}
		return solutions;
	}
}
