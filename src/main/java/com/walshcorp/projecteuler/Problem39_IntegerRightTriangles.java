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
		int maxSolutions = -1;
		// Smallest right angled triangle is a 3,4,5 => starting p = 12
		for (int p = 12; p <= 1000; p++) {
			// a < c for a+b+c=p.
			// max c = p/2 => limit_a = p/2
			int limit = p / 2;
			int sol = 0;
			for (int a = 1; a < limit; a++) {
				double b = b(a, p);
				if (b == Math.rint(b)) {
					// For all whole number values of a, b and consequently c:
					sol++;
				}
			}

			if (sol > maxSolutions) {
				maxSolutions = sol;
				largestP = p;
			}
		}
		System.out.println("Problem 39: " + largestP);
	}

	/**
	 * Finds other side for Pythagorean triplet given one side and total
	 * perimeter.<br />
	 * Given:<br />
	 * a+b+c = P<br />
	 * => c = P-a-b<br />
	 * And:<br />
	 * a^2 + b^2 = c^2<br />
	 * <br />
	 * => a^2 + b^2 = (P-a-b)^2<br />
	 * => a^2 + b^2 = (P-(a-b))^2<br />
	 * => a^2 + b^2 = P^2 - 2P(a-b) + (a-b)^2<br />
	 * => a^2 + b^2 = P^2 - 2P(a-b) + a^2 - 2ab + b^2<br />
	 * => 0 = P^2 - 2Pa + 2Pb - 2ab<br />
	 * => 2b(a - P) = P^2 - 2Pa<br />
	 * => b = (P^2 - 2Pa)/(2(a - P))<br />
	 * 
	 * @param a
	 *            One side of triangle
	 * @param p
	 *            Total perimeter
	 * @return
	 */
	private double b(double a, double p) {
		return (p * p - 2 * p * a) / (2 * (a - p));
	}
}
