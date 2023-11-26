package classes.scaler.DSA.MODULE2.slidingWindowAndContributionTechnique

/*
Problem Description
Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
We may assume that there is no overflow.

Problem Constraints
1 <= N <= 103
1 <= A[i] <= 1000
1 <= B <= 107

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return an integer denoting the number of sub-arrays in A having sum less than B.

Example Input
Input 1:
 A = [2, 5, 6]
 B = 10
Input 2:
 A = [1, 11, 2, 3, 15]
 B = 10

Example Output
Output 1:
 4
Output 2:
 4

Example Explanation
Explanation 1:
 The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
Explanation 2:
 The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
* */

fun main() {
    println(subArraySumLessThan(intArrayOf(2, 5, 6), 10))
    println(subArraySumLessThan(intArrayOf(1, 11, 2, 3, 15), 10))

    println("Sum equal to 7: " + subArraySumEqualTo(intArrayOf(3, 4, 7, 2, -3, 1, 4, 2), 7))
}

fun subArraySumLessThan(A: IntArray, B: Int): Int {
    //Create prefix sum array
    val prefixSum = IntArray(A.size)
    prefixSum[0] = A[0]
    for (i in 1 until A.size)
        prefixSum[i] = prefixSum[i - 1] + A[i]

    //Now traverse all the sub-array, and check required conditions
    var ans = 0
    for (i in A.indices) {
        for (j in i until A.size) {
            //Calculate length of sub-array
            val lengthOfSubArray = (j - i + 1)
            //Calculate the sum of sub-array from i to j using prefixSum array
            val sumOfSubArray = if (i == 0) prefixSum[j] else prefixSum[j] - prefixSum[i - 1]
            if (sumOfSubArray < B)
                ans += 1
        }
    }
    return ans
}

fun subArraySumEqualTo(A: IntArray, B: Int): Int {
    //Create prefix sum array
    val prefixSum = IntArray(A.size)
    prefixSum[0] = A[0]
    for (i in 1 until A.size)
        prefixSum[i] = prefixSum[i - 1] + A[i]

    //Now traverse all the sub-array, and check required conditions
    var ans = 0
    for (i in A.indices) {
        for (j in i until A.size) {
            //Calculate length of sub-array
            val lengthOfSubArray = (j - i + 1)
            //Calculate the sum of sub-array from i to j using prefixSum array
            val sumOfSubArray = if (i == 0) prefixSum[j] else prefixSum[j] - prefixSum[i - 1]
            if (sumOfSubArray == B)
                ans += 1
        }
    }
    return ans
}