
title = { 'Problem 16: Power Digit Sum' }

description = {
    """
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
"""
}

solve = {
    BigInteger n = 2**1000
    def nf = java.text.NumberFormat.instance
    nf.setGroupingUsed(false)
    return nf.format(n).collect {it.toInteger()}.sum()
}
