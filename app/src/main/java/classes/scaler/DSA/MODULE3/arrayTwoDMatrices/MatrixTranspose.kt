package classes.scaler.DSA.MODULE3.arrayTwoDMatrices

import com.google.gson.Gson

/*
Problem Description
Given a 2D integer array A, return the transpose of A.
The transpose of a matrix is the matrix flipped over its main diagonal,
switching the matrix's row and column indices.

Problem Constraints
1 <= A.size() <= 1000
1 <= A[i].size() <= 1000
1 <= A[i][j] <= 1000

Input Format
First argument is a 2D matrix of integers.

Output Format
You have to return the Transpose of this 2D matrix.

Example Input
Input 1:
A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2:
A = [[1, 2],[1, 2],[1, 2]]

Example Output
Output 1:
[[1, 4, 7], [2, 5, 8], [3, 6, 9]]
Output 2:
[[1, 1, 1], [2, 2, 2]]

Example Explanation
Explanation 1:
Clearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
 we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].
Explanation 2:
After transposing the matrix, A becomes [[1, 1, 1], [2, 2, 2]]
* */

fun main() {
    val list = transposeOfSquareMatrix(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    )

    val list1 = transposeOfNonSquareMatrix(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2),
            intArrayOf(1, 2)
        )
    )

    println(Gson().toJson(list))
    println(Gson().toJson(list1))
}

fun transposeOfSquareMatrix(A: Array<IntArray>): Array<IntArray> {
    for (i in 0 until A.size) {
        for (j in (i + 1) until A.size) {
            val temp = A[i][j]
            A[i][j] = A[j][i]
            A[j][i] = temp
        }
    }
    return A
}

fun transposeOfNonSquareMatrix(A: Array<IntArray>): Array<IntArray> {
    val N = A.size//Row
    val M = A[0].size//Column
    val transposeList = Array<IntArray>(M, init = { IntArray(N) })

    for (i in 0 until M) {
        for (j in 0 until N) {
            transposeList[i][j] = A[j][i]
        }
    }
    return transposeList
}