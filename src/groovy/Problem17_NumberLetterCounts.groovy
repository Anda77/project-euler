
title = { 'Problem 17: Number Letter Counts' }

description = {
    """
If the numbers 1 to 5 are written out in words:
one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens.
For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
The use of "and" when writing out numbers is in compliance with British usage.
"""
}

solve = {
    def limit = 1000
    long sum = 0
    (0..limit).each { n ->
        if (n < 100) {
            sum += getNumberUpToOneHundred(n)
        } else if (n < 1000) {
            int hundreds = (n / 100).toInteger()
            sum += numbers(hundreds)
            sum += numbers(100)
            int remainder = n % 100
            if (remainder) {
                sum += numbers('and')
                sum += getNumberUpToOneHundred(remainder)
            }
        } else {
            sum += numbers(1)
            sum += numbers(1000)
        }
    }
    return sum
}

numbers = { n ->
    def data = [
        (0): '',
        (1): 'one',
        (2): 'two',
        (3): 'three',
        (4): 'four',
        (5): 'five',
        (6): 'six',
        (7): 'seven',
        (8): 'eight',
        (9): 'nine',
        (10): 'ten',
        (11): 'eleven',
        (12): 'twelve',
        (13): 'thirteen',
        (14): 'fourteen',
        (15): 'fifteen',
        (16): 'sixteen',
        (17): 'seventeen',
        (18): 'eighteen',
        (19): 'nineteen',
        (20): 'twenty',
        (30): 'thirty',
        (40): 'forty',
        (50): 'fifty',
        (60): 'sixty',
        (70): 'seventy',
        (80): 'eighty',
        (90): 'ninety',
        (100): 'hundred',
        (1000): 'thousand',
        and: 'and'
    ]

    return data[n].size()
}.memoize()

getNumberUpToOneHundred = { n ->
    int sum = 0
    if (n < 20) {
        sum += numbers(n)
    } else if (n < 30) {
        sum += numbers(20)
        sum += numbers(n - 20)
    } else if (n < 40) {
        sum += numbers(30)
        sum += numbers(n - 30)
    } else if (n < 50) {
        sum += numbers(40)
        sum += numbers(n - 40)
    } else if (n < 60) {
        sum += numbers(50)
        sum += numbers(n - 50)
    } else if (n < 70) {
        sum += numbers(60)
        sum += numbers(n - 60)
    } else if (n < 80) {
        sum += numbers(70)
        sum += numbers(n - 70)
    } else if (n < 90) {
        sum += numbers(80)
        sum += numbers(n - 80)
    } else if (n < 100) {
        sum += numbers(90)
        sum += numbers(n - 90)
    }
    return sum
}
