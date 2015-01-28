
title = { 'Problem 9: Special Pythagorean Triplet' }

description = {
    """
A Pythagorean triplet is a set of three natural numbers, a b c, for which a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product a * b * c.
"""
}

solve = {
    def result

    for (a in 1..500) {
        for (b in 2..500) {
            def c = Math.sqrt(a**2 + b**2)

            if ((a + b + c) == 1000) {
                result = a*b*c
                break
            }
        }
    }
    
    return result.round()
}
