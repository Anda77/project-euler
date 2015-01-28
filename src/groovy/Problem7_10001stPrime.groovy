
title = { 'Problem 7: 10001st Prime Number' }

description = {
    """
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
that the 6th prime is 13.

What is the 10001st prime number?
"""
}

solve = {
    int counter = 1
    def primes = [2]

    def candidate = 3

    while(counter < 10001) {
        // A number is prime if any other prime does not divide into it!
        if (!primes.any { candidate % it == 0 }) {
            primes << candidate
            counter++
        }

        candidate++
    }

    return primes[-1]
}
