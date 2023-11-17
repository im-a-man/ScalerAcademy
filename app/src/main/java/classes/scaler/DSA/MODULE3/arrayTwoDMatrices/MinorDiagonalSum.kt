package classes.scaler.DSA.MODULE3.arrayTwoDMatrices

import kotlin.math.min

/*
Problem Description
You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
Minor diagonal of a M X M matrix A is a collection of elements A[i, j],
such that i + j = M + 1 (where i, j are 1-based).

Note =>
[
    (where i, j are 0-based).
        i+j = N + 1
        j = (N + 1 - i)
]

Problem Constraints
1 <= N <= 103
-1000 <= A[i][j] <= 1000

Input Format
First and only argument is a 2D integer matrix A.

Output Format
Return an integer denoting the sum of minor diagonal elements.

Example Input
Input 1:
 A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
Input 2:
 A = [[3, 2],
      [2, 3]]

Example Output
Output 1:
 -5
Output 2:
 4

Example Explanation
Explanation 1:
 A[1][3] + A[2][2] + A[3][1] = (-3) + 5 + (-7) = -5
Explanation 2:
 A[1][2] + A[2][1] = 2 + 2 = 4
* */

fun main() {
    println(
        minorSum(
            arrayOf(
                intArrayOf(1, -2, -3),
                intArrayOf(-4, 5, -6),
                intArrayOf(-7, -8, 9)
            )
        )
    )
}

fun minorSum(A: Array<IntArray>): Int {
    /*
        i + j = N + 1 (where i, j are 1-based).
        j = (N + 1 - i) (where i, j are 0-based).
    */
    var minorSum = 0
    for (i in A.indices) {
        minorSum += A[i][A.size - 1 - i]
    }
    return minorSum
}