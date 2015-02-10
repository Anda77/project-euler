
title = { 'Problem 19: Counting Sundays' }

description = {
    """
You are given the following information, but you may prefer to do some research for yourself.

- 1 Jan 1900 was a Monday.
- Thirty days has September,
- April, June and November.
- All the rest have thirty-one,
- Saving February alone,
- Which has twenty-eight, rain or shine.
- And on leap years, twenty-nine.
- A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
"""
}

solve = {
    def dateFormat = 'yyyy-MM-dd'
    def start = Date.parse(dateFormat, '1901-01-01')
    def end = Date.parse(dateFormat, '2000-12-31')
    
    def calendar = Calendar.instance

    def sundays = 0

   (start..end).each { date ->
        calendar.time = date

        if (calendar.get(Calendar.DATE) == 1 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            sundays++
        }
    }

    return sundays
}
