package classes.scaler.DSA.MODULE2.caryForwardAndSubArray

/*
Q3=>Additional problem
Problem Description
You are given an integer array A of size N.
You have to perform B operations. In one operation,
you can remove either the leftmost or the rightmost element of the array A.

Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:

Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.

Problem Constraints
1 <= N <= 105
1 <= B <= N
-103 <= A[i] <= 103

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return an integer denoting the maximum possible sum of elements you removed.
* */

fun main() {
    val A = intArrayOf(5, -2, 3, 1, 2)
    val B = 3//output=8
    val A1 = intArrayOf(2, 3, -1, 4, 2, 1)
    val B1 = 4//output=9

    val N = A.size
    val prefixSum = IntArray(N)
    val suffixSum = IntArray(N)

    prefixSum[0] = A[0]
    for (i in 1 until N) {
        prefixSum[i] = prefixSum[i - 1] + A[i]
    }

    suffixSum[N - 1] = A[N - 1]
    for (i in (N - 2) downTo 0) {
        suffixSum[i] = suffixSum[i + 1] + A[i]
    }

    var maxSum = maxOf(prefixSum[B - 1], suffixSum[N - B])
    for (i in 1 until B) {
        val sum = prefixSum[i - 1] + suffixSum[N - (B - i)]
        maxSum = maxOf(maxSum, sum)
    }
    println(maxSum)
}