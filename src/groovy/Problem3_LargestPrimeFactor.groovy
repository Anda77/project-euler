
title = { 'Problem 3: Largest Prime Factor' }

description = {
    """
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
"""
}

solve = {
    double number = 600851475143D
    int check = 2

    def prime

    while (number != 1) {
        if (number % check == 0) {
            prime = check
            number = number / check
        } else {
            check++
        }
    }

    return prime
}
