package classes.scaler.DSA.MODULE4.bitManipulation2

/**
Problem Description
Given an array of integers, every element appears thrice except for one, which occurs once.
Find that element that does not appear thrice.
NOTE: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?

Problem Constraints
2 <= A <= 5*106
0 <= A <= INTMAX

Input Format
First and only argument of input contains an integer array A.

Output Format
Return a single integer.

Example Input
Input 1:
A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2:
A = [0, 0, 0, 1]

Example Output
Output 1:
4
Output 2:
1

Example Explanation
Explanation 1:
4 occurs exactly once in Input 1.
1 occurs exactly once in Input 2.
 * */

fun main() {
    println(singleNumberByCounting1(intArrayOf(1, 2, 4, 3, 3, 2, 2, 3, 1, 1)))
}
fun singleNumberByCounting1(A: IntArray): Int {
    var ans = 0
    for (i in 0..<32) {
        //Count the set-bits in all numbers at ith bit position.
        var count = 0
        for (j in A.indices) {
            if ((A[j] and (1 shl i)) != 0) {
                //i-th bit is set
                count++
            }
        }
        if (count % 3 == 1) {
            //Set the i-th bit in the ans
            ans = ans or (1 shl i)
        }
    }
    return ans
}