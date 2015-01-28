
title = { 'Problem 5: Smallest Multiple' }

description = {
    """
2520 is the smallest number that can be divided by each of the numbers from 1
to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the
numbers from 1 to 20?
"""
}

solve = {
	// Using prime factorisation:
	// -> 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
	return 2**4 * 3**2 * 5 * 7 * 11 * 13 * 17 * 19
}
