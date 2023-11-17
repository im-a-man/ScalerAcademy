package classes.scaler.DSA.MODULE2.slidingWindowAndContributionTechnique

/*
Problem Description
Given an array A of size N, find the subarray of size B with the least average.

Problem Constraints
1 <= B <= N <= 105
-105 <= A[i] <= 105

Input Format
First argument contains an array A of integers of size N.
Second argument contains integer B.

Output Format
Return the index of the first element of the subarray of size B that has least average.
Array indexing starts from 0.

Example Input
Input 1:
A = [3, 7, 90, 20, 10, 50, 40]
B = 3
Input 2:
A = [3, 7, 5, 20, -10, 0, 12]
B = 2

Example Output
Output 1:
3
Output 2:
4

Example Explanation
Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average
among all subarrays of size 3.

Explanation 2:
Subarray between [4, 5] has minimum average
* */

fun main() {
    println(solve2(intArrayOf(3, 7, 90, 20, 10, 50, 40), 3))
    println(solve2(intArrayOf(3, 7, 5, 20, -10, 0, 12), 2))
    println(solve2(intArrayOf(15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18), 6))
    println(solve2(intArrayOf(20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11), 9))
}

fun solve2(A: IntArray, B: Int): Int {
    //B is Length
    //Creating first window
    var sum = 0
    for (i in 0 until B)
        sum += A[i]

    var leastAverage = sum
    var answerIndex = 0

    //Now Sliding the window
    var sIndex = 1
    var eIndex = B
    while (eIndex < A.size) {
        sum = sum + A[eIndex] - A[sIndex - 1]
        if ( sum < leastAverage) {
            leastAverage = sum
            answerIndex = (sIndex)//Updating the start index of least average's subarray
        }
        sIndex++
        eIndex++
    }
    return answerIndex
}