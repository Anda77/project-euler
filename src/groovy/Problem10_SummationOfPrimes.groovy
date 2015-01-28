
title = { 'Problem 10: Summation of Primes' }

description = {
    """
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
"""
}

solve = {

    Integer n = 2000000

    //Assume everything is prime
    Map<Integer, Boolean> isPrime = (2..n).inject([:]) { map, i ->
        map[i] = true
        map
    }

    //Mark non primes
    for (int i = 2; i**2 <= n; i++) {
        if (isPrime[i]) {
            def multipleLimit = n / i
            for (int j = i; i*j <= n; j++) {
                isPrime[i*j] = false
            }
        }
    }

    //Now sum the primes
    long sum = 0
    isPrime.each { k, v ->
        if(v) {
            sum += k
        }
    }

    return sum
}
