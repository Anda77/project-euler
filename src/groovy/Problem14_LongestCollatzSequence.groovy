
title = { 'Problem 14: Longest Collatz Sequence' }

description = {
    """
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.

Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
"""
}

solve = {
    int maxLength = 0
    int maxStart = 0

	for (int n = 2; n < 1000000; n++) {
		int length = collatzLength(n)

	    if (length > maxLength) {
	    	maxLength = length
	    	maxStart = n
	    }
	}
    return "$maxStart ($maxLength)"
}

collatz = { n ->
	if (n % 2 == 0) {
		return n/2
	} else {
		return 3*n + 1
	}
}.memoize()

collatzLength = { n ->
	long num = n
	int length = 1
	while(num > 1) {
		num = collatz(num)
		length++	
	}
	return length
}.memoize()
