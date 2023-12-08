package classes.scaler.DSA.MODULE3.interviewProblems

import classes.GsonFactory.toJson

/**
Problem Description

You are given a 2D integer matrix A, make all the elements in a row or column zero
if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.

Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
0 <= A[i][j] <= 103

Input Format
First argument is a 2D integer matrix A.

Output Format
Return a 2D matrix after doing required operations.

Example Input
Input 1:
[1,2,3,4]
[5,6,7,0]
[9,2,0,4]

Example Output
Output 1:
[1,2,0,0]
[0,0,0,0]
[0,0,0,0]

Example Explanation
Explanation 1:
A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
 * */

fun main() {
    val arr = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 0),
        intArrayOf(9, 2, 0, 4)
    )
    arr.forEach { println(it.toJson()) }
    val array = zero(arr)
    array.forEach { println(it.toJson()) }
}

fun zero(A: Array<IntArray>): Array<IntArray> {
    val N = A.size
    val M = A[0].size

    for (row in 0 until N) {
        var isZeroExist = false
        for (col in 0 until M)
            if (A[row][col] == 0) {
                isZeroExist = true
                break
            }
        if (isZeroExist) {
            for (col in 0 until M)
                if (A[row][col] != 0) {
                    A[row][col] = -1
                }
        }
    }

    for (col in 0 until M) {
        var isZeroExist = false
        for (row in 0 until N)
            if (A[row][col] == 0) {
                isZeroExist = true
                break
            }
        if (isZeroExist) {
            for (row in 0 until N) {
                if (A[row][col] != 0) {
                    A[row][col] = -1
                }
            }
        }
    }

    repeat(A.size) { i ->
        repeat(A[i].size) { j ->
            if (A[i][j] == -1)
                A[i][j] = 0
        }
    }
    return A
}