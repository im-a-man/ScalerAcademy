package classes.scaler.DSA.MODULE4.interviewProblems

/**
Problem Description
Given an integer A, find and return the total number of digit 1 appearing in
all non-negative integers less than or equal to A.

Problem Constraints
0 <= A <= 109

Input Format
The only argument given is the integer A.

Output Format
Return the total number of digit 1 appearing in all non-negative integers less than or equal to A.

Example Input
Input 1:
A = 10
Input 2:
A = 11

Example Output
Output 1:
2
Output 2:
4

Example Explanation
Explanation 1:
Digit 1 appears in 1 and 10 only and appears one time in each. So the answer is 2.
Explanation 2:
Digit 1 appears in 1(1 time) , 10(1 time) and 11(2 times) only. So the answer is 4.
 * */

fun main() {
    println(solve(10))
    println(solve1(10))
    println(solve(11))
    println(solve1(11))
}

fun solve(A: Int): Int {
    if (A == 0) return 0
    var ans = 0
    var i = 1
    while (A / i > 0) {
        ans += A / (i * 10) * i + minOf(maxOf(A % (i * 10) - (i - 1), 0), i)
        i *= 10
    }
    return ans
}

fun solve1(A: Int): Int {
    /**
     * Theory:
     * 1. Find the contribution of 1 for each places eg. for unit,tenth,hundredth ... places.
     * 2. Add all the contributions
     * eg:
     * Unit place:
     * 0-9, 10-19, 20-29,30-39 => 1 after every 10 digit
     *
     * Tenth Place:
     * 00-99(10-19)  , 100-199, 200-299, 300-399 => 10 after every 100 digits
     *
     * eg: 235
     * Unit place:
     * ans += (235/10)*1 + (235%10)>1? 1 : (235%10)>0? 1:0
     *
     * Tenth Place:
     * ans += (235/100)*10+ (235%100)>19? 10 : (235%100)>9? 35-9:0
     *
     * Hundred Place:
     * ans += (235/1000)*100+ (235%1000)>199? 100 : (235%1000)>99? 235-99:0
    * */
    fun totalNumDigit(num: Int, digits: Int): Int {
        if (digits == 0) return 0
        val dN_1 = Math.pow(10.0, (digits - 1).toDouble()).toInt()
        val dN = Math.pow(10.0, digits.toDouble()).toInt()
        val a = num / dN
        val b = num % dN
        var ans = a * dN_1
        if (b > 2 * dN_1 - 1) {  // eg: b : 35, if(b>19) => ans += 10
            ans += dN_1
        } else if (b > dN_1 - 1) { // eg:b is 17,  b>9 => ans += 17-9
            ans += b - dN_1 + 1
        }
        return ans + totalNumDigit(num, digits - 1)
    }
    //----------------------------------------------------------------
    var tmp = A
    var n = 0
    while (tmp > 0) {
        n++
        tmp /= 10
    }
    return totalNumDigit(A, n)
}