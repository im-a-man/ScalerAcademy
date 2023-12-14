package classes.scaler.DSA.MODULE4.bitManipulation2

import channel.example8.newTree

/**
Problem Description
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Problem Constraints
1 <= |A| <= 2000000
0 <= A[i] <= INTMAX

Input Format
The first and only argument of input contains an integer array A.

Output Format
Return a single integer denoting the single element.

Example Input
Input 1:
A = [1, 2, 2, 3, 1]
Input 2:
A = [1, 2, 2]

Example Output
Output 1:
3
Output 2:
1

Example Explanation
Explanation 1:
3 occurs once.
Explanation 2:
1 occurs once.
 * */

fun main() {
    println(singleNumberByXOR(intArrayOf(1, 2, 2, 3, 1)))
    println(singleNumberByCounting(intArrayOf(1, 2, 2, 3, 1)))
}

fun singleNumberByXOR(A: IntArray): Int {
    var ans = 0
    for (i in A.indices) {
        ans = ans xor A[i]
    }
    return ans
}

fun singleNumberByCounting(A: IntArray): Int {
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
        if (count % 2 == 1) {
            //Set the i-th bit in the ans
            ans = ans or (1 shl i)
        }
    }
    return ans
}