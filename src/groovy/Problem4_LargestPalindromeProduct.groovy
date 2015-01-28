
title = { 'Problem 4: Largest Palindrome Product' }

description = {
    """
A palindromic number reads the same both ways. The largest palindrome made
from the product of two 2-digit numbers is 9009 = 91 99.

Find the largest palindrome made from the product of two 3-digit numbers.
"""
}

solve = {
    def min = 100
    def max = 999

    def result = 0

    for (i in 999..100) {
        for(j in 999..100) {
            def product = i * j
            if (isPalindrome(product)) {
                if (product > result) {
                    result = product
                }
            }
        }
    }

    return result
}

isPalindrome = { product ->
    def chars = product.toString().getChars()
    int half = (chars.size() / 2).toInteger()
    for (int i in 0..half) {
        if (chars[i] != chars[-(i+1)]) {
            return false
        }
    }
    return true
}
