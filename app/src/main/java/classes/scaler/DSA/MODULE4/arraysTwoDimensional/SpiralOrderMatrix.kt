package classes.scaler.DSA.MODULE4.arraysTwoDimensional

import classes.GsonFactory.toJson

/**
Problem Description
Given an integer A, generate a square matrix filled with elements
from 1 to A2 in spiral order and return the generated square matrix.

Problem Constraints
1 <= A <= 1000

Input Format
First and only argument is integer A

Output Format
Return a 2-D matrix which consists of the elements added in spiral order.

Example Input
Input 1:
1
Input 2:
2
Input 3:
5

Example Output
Output 1:
[ [1] ]
Output 2:
[ [1, 2],
[4, 3] ]
Output 3:
[ [1,   2,  3,  4, 5],
[16, 17, 18, 19, 6],
[15, 24, 25, 20, 7],
[14, 23, 22, 21, 8],
[13, 12, 11, 10, 9] ]

Example Explanation
Explanation 1:
Only 1 is to be arranged.
Explanation 2:
1 --> 2
|
|
4<--- 3
 * */

fun main() {
    spiralMatrix(5).forEach { println(it.toJson()) }
}

fun spiralMatrix(A: Int): Array<IntArray> {
    val matrix = Array(A) { IntArray(A) }
    var N = matrix.size

    var i = 0
    var j = 0
    var value = 1

    while (N > 1) {
        //Print (N-1) elements of 0th row
        for (K in 0 until (N - 1)) {//0..(N-2) or 0 to <= (N-2)
            //i = 0
            //j = 0,1,2,3
            matrix[i][j] = value++
            j++
        }
        //Print (N-1) elements of last column
        for (K in 0 until (N - 1)) {
            //i = 0,1,2,3
            //j = 3
            matrix[i][j] = value++
            i++
        }
        //Print (N-1) elements of last row
        for (K in 0 until (N - 1)) {
            //i = 3
            //j = 3,2,1,0
            matrix[i][j] = value++
            j--
        }
        //Print (N-1) elements of 0th column
        for (K in 0 until (N - 1)) {
            //i = 3,2,1,0
            //j = 0
            matrix[i][j] = value++
            i--
        }
        i++
        j++
        N -= 2
    }
    if (N == 1) matrix[i][j] = value
    return matrix
}