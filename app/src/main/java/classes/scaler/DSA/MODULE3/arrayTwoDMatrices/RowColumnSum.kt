package classes.scaler.DSA.MODULE3.arrayTwoDMatrices

/*
Problem Description
You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.

Problem Constraints
1 <= A.size() <= 103
1 <= A[i].size() <= 103
1 <= A[i][j] <= 103

Input Format
First argument is a 2D array of integers.(2D matrix).

Output Format
Return an array containing column-wise sums of original matrix.

Example Input
Input 1:
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]

Example Output
Output 1:
{15,10,13,16}

Example Explanation
Explanation 1
Column 1 = 1+5+9 = 15
Column 2 = 2+6+2 = 10
Column 3 = 3+7+3 = 13
Column 4 = 4+8+4 = 16
* */

fun main() {
    println(
        "Row-wise Sum => "+ rowSum(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 2, 3, 4)
            )
        ).joinToString()
    )
    println(
        "Column-wise Sum => "+ columnSum(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 2, 3, 4)
            )
        ).joinToString()
    )
}

fun columnSum(A: Array<IntArray>): IntArray {
    val arrayList = arrayListOf<Int>()

    for (col in 0 until A[0].size) {
        var sum = 0
        for (row in A.indices) {
            sum += A[row][col]
        }
        arrayList.add(sum)
    }

    return arrayList.toIntArray()
}

fun rowSum(A: Array<IntArray>): IntArray {
    val arrayList = arrayListOf<Int>()

    for (row in A.indices) {
        var sum = 0
        for (col in 0 until  A[0].size) {
            sum += A[row][col]
        }
        arrayList.add(sum)
    }

    return arrayList.toIntArray()
}