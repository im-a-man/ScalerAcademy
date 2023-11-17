package classes.scaler.interviewPreparation.codingProblems

import kotlin.math.max

fun lis(arr: IntArray): Int {
    val n = arr.size
    val lis = IntArray(n)
    lis[0] = 1
    /* Compute optimized LIS values in bottom up manner */
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (arr[i] > arr[j] && lis[i] < (lis[j] + 1)) {
                lis[i] = lis[j] + 1
            }
        }
    }
    // Return maximum value in lis[]
    return lis.max()
}

fun main(args: Array<String>) {
    val arr = intArrayOf(10, 22, 9, 33, 21, 50, 41, 60)
    val length = lis(arr)
    println("Length of the longest increasing subsequence is: $length")

    val arr1 = intArrayOf(10, 22, 9, 33, 21, 50, 41, 60, 64)
    val length1 = longestContiguousIncreasingSubsequence(arr1)
    println("Length of the longest contiguous increasing subsequence is: $length1")
}

fun longestContiguousIncreasingSubsequence(arr: IntArray): Int {
    val n = arr.size
    if (n <= 1) {
        return n
    }
    var maxContiguousLength = 1
    var currentLength = 1
    for (i in 1 until n) {
        if (arr[i] > arr[i - 1]) {
            currentLength++
        } else {
            maxContiguousLength = max(maxContiguousLength, currentLength)
            currentLength = 1
        }
    }
    return max(maxContiguousLength, currentLength)
}