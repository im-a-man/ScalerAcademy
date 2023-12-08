package classes.scaler.DSA.MODULE4.interviewProblems

import classes.GsonFactory.toJson

/**
Problem Description
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.

NOTE:
The replacement must be in-place, do not allocate extra memory.
DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.

Problem Constraints
1 <= N <= 5 * 105
1 <= A[i] <= 109

Input Format
The first and the only argument of input has an array of integers, A.

Output Format
Return an array of integers, representing the next permutation of the given array.

Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [3, 2, 1]

Example Output
Output 1:
[1, 3, 2]
Output 2:
[1, 2, 3]

Example Explanation
Explanation 1:
Next permutaion of [1, 2, 3] will be [1, 3, 2].
Explanation 2:
No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
So will rearranges it in the lowest possible order.
 * */

fun main() {
    //I'll ask this to sir
    println(nextPermutation(intArrayOf(1, 2, 3)).toJson())
    println(nextPermutation(intArrayOf(3, 2, 1)).toJson())
}

fun nextPermutation(A: IntArray): IntArray {
    fun reverseArr(A: IntArray, i: Int, j: Int): IntArray {
        var i = i
        var j = j
        val N = A.size
        while (i < j) {
            val temp = A[i]
            A[i] = A[j]
            A[j] = temp
            i++
            j--
        }
        return A
    }

    // find first decreasing element from right
    val N = A.size
    var i = N - 2
    while (i >= 0 && A[i] >= A[i + 1]) {
        i--
    }
    if (i >= 0) {
        //find smallest number greater than A[i] from right
        var j = N - 1
        while (j > i && A[j] <= A[i]) {
            j--
        }
        val temp = A[i]
        A[i] = A[j]
        A[j] = temp
    }
    reverseArr(A, i + 1, N - 1)
    return A
}