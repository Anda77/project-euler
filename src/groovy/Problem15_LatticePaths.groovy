
title = { 'Problem 15: Lattice Paths' }

description = {
    """
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?
"""
}

solve = {
    double r = 20
    double n = 2*r

    def nf = java.text.NumberFormat.instance
    nf.setGroupingUsed(false)

    // ans = n!/r!(n-r)! where n = 2r
    return nf.format(factorial(n) / (factorial(r) * factorial(n - r)))
}

factorial = { n ->
    double result = 1
    if (n > 1) {
        result *= factorial(n - 1)
        result *= n
    }
    return result
}
