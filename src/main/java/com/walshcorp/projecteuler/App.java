package com.walshcorp.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Solver
 * 
 */
public class App {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		List<ProblemInterface> problemList = new ArrayList<ProblemInterface>();

		problemList.add(new Problem1_Multiples());
		problemList.add(new Problem2_EvenFibonacci());
		problemList.add(new Problem3_LargestPrimeFactor());
		problemList.add(new Problem4_LargestPalindromeProduct());
		problemList.add(new Problem5_SmallestMultiple());
		problemList.add(new Problem6_SumSquareDifference());
		problemList.add(new Problem7_10001stPrime());
		problemList.add(new Problem8_LargestProduct());
		problemList.add(new Problem9_SpecialPythagoreanTriplet());
		problemList.add(new Problem10_SummationOfPrimes());
		problemList.add(new Problem11_LargestProductInAGrid());
		problemList.add(new Problem12_TriangularNumbers());
		problemList.add(new Problem13_LargeSum());
		problemList.add(new Problem14_LongestCollatzSequence());
		problemList.add(new Problem15_LatticePaths());
		problemList.add(new Problem16_PowerDigitSum());
		problemList.add(new Problem17_NumberLetterCounts());
		problemList.add(new Problem18_MaximumPathSumI());
		problemList.add(new Problem19_CountingSundays());
		problemList.add(new Problem20_FactorialDigitSum());
		problemList.add(new Problem21_AmicableNumbers());
		problemList.add(new Problem22_NameScores());
		problemList.add(new Problem23_NonAbundantSums());
		problemList.add(new Problem24_LexicographicPermutations());
		problemList.add(new Problem25_1000DigitFibonacciNumber());
		problemList.add(new Problem26_ReciprocalCycles());
		problemList.add(new Problem27_QuadraticPrimes());
		problemList.add(new Problem28_NumberDiagonalSpirals());
		problemList.add(new Problem29_DistinctPowers());
		problemList.add(new Problem30_DigitFifthPowers());
		problemList.add(new Problem31_CoinSums());
		problemList.add(new Problem32_PandigitalProducts());
		problemList.add(new Problem33_DigitCancellingFractions());
		problemList.add(new Problem34_DigitFactorials());
		problemList.add(new Problem35_CircularPrimes());
		problemList.add(new Problem36_DoubleBasePalindromes());
		problemList.add(new Problem37_TruncatablePrimes());
		problemList.add(new Problem38_PandigitalMultiples());
		problemList.add(new Problem39_IntegerRightTriangles());
		problemList.add(new Problem40_ChampernownesConstant());
		problemList.add(new Problem41_PandigitalPrime());
		problemList.add(new Problem42_CodedTriangleNumbers());
		problemList.add(new Problem43_SubstringDivisibility());
		problemList.add(new Problem44_PentagonNumbers());
		problemList.add(new Problem45_TriangularPentagonalAndHexagonal());

		problemList.add(new Problem67_MaximumPathSumII());

		solveProblems(problemList);
		long stop = System.currentTimeMillis();
		long time = (stop - start);
		System.out.println("Elapsed: " + time + "ms");
	}

	private static void solveProblems(List<ProblemInterface> problems) {
		for (ProblemInterface problem : problems) {
			long start = System.currentTimeMillis();
			problem.solve();
			long end = System.currentTimeMillis();
			if ((end - start) > 2000) {
				System.out.println("IMPROVE EFFICIENCY OF ABOVE SOLUTION.");
			}
		}
	}
}
