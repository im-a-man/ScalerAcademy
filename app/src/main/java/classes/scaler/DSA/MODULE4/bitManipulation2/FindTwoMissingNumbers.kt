package classes.scaler.DSA.MODULE4.bitManipulation2

import classes.GsonFactory.toJson

/**
Problem Description
Given an array A of length N where all the elements are distinct and are in the range [1, N+2].
Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.

Problem Constraints
1 <= N <= 105
1 <= A[i] <= N+2
The elements of array A are distinct

Input Format
Only argument A is an array of integers

Output Format
Return a sorted array of size 2 denoting the missing elements.

Example Input
Input 1:
A = [3, 2, 4]
Input 2:
A = [5, 1, 3, 6]

Example Output
Output 1:
[1, 5]
Output 2:
[2, 4]

Example Explanation
For Input 1:
The missing numbers are 1 and 5.
For Input 2:
The missing numbers are 2 and 4.
 * */

fun main() {
    println(findTwoMissingNumbers(intArrayOf(3, 2, 4)).toJson())
    println(findTwoMissingNumbers(intArrayOf(5, 1, 3, 6)).toJson())
}

fun findTwoMissingNumbers(A: IntArray): IntArray {
    var xorOfAll = 0
    for (i in A.indices)//xor of all numbers present in array that is in range of [1,N+2]
        xorOfAll = xorOfAll xor A[i]
    for (i in 1..(A.size + 2))//xor of all numbers from 1 to N+2
        xorOfAll = xorOfAll xor i

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
    for (i in 1..(A.size + 2)) {
        if ((i and (1 shl anySetBitPosition)) != 0)
            integerOne = integerOne xor i
        else
            integerTwo = integerTwo xor i
    }
    return intArrayOf(minOf(integerOne, integerTwo), maxOf(integerOne, integerTwo))
}