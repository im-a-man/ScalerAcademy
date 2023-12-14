package classes.scaler.DSA.MODULE4.bitManipulation2

import classes.GsonFactory.toJson

/**
Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.
Note: Return the two numbers in ascending order.

Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109

Input Format
The first argument is an array of integers of size N.

Output Format
Return an array of two integers that appear only once.

Example Input
Input 1:
A = [1, 2, 3, 1, 2, 4]
Input 2:
A = [1, 2]

Example Output
Output 1:
[3, 4]
Output 2:
[1, 2]

Example Explanation
Explanation 1:
3 and 4 appear only once.
Explanation 2:
1 and 2 appear only once.
 * */

fun main() {
    println(twoSingleNumbers3(intArrayOf(1, 2, 3, 1, 2, 4)).toJson())
}

fun twoSingleNumbers3(A: IntArray): IntArray {
    //1: Take xor of all the elements
    var xorOfAll = 0
    for (i in A.indices)
        xorOfAll = xorOfAll xor A[i]
    //2: Find any set bit position in xorOfAll
    var anySetBitPosition = 0
    for (i in 0 until 32) {
        if ((xorOfAll and (1 shl i)) != 0) {
            anySetBitPosition = i
            break
        }
    }
    //3: Split the array on the basis of anySetBitPosition-th bit
    var integerOne = 0
    var integerTwo = 0
    for (i in A.indices) {
        if ((A[i] and (1 shl anySetBitPosition)) != 0)
            integerOne = integerOne xor A[i]
        else
            integerTwo = integerTwo xor A[i]
    }
    return intArrayOf(minOf(integerOne, integerTwo), maxOf(integerOne, integerTwo))
}