package classes.scaler.DSA.MODULE4.arraysOneDimensional

import kotlin.math.max


/*
* Problem Description
Given a vector A of non-negative integers representing an elevation map
where the width of each bar is 1, compute how much water it is able to trap after raining.

Problem Constraints
1 <= |A| <= 100000

Input Format
First and only argument is the vector A
Output Format
Return one integer, the answer to the question

Example Input
Input 1:
A = [0, 1, 0, 2]
Input 2:
A = [1, 2]

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
1 unit is trapped on top of the 3rd element.
Explanation 2:
No water is trapped.
* */

fun main() {
    println(trapBruteForceIdea(intArrayOf(0, 1, 0, 2)))//T.C=> O(N square), S.C=> O(1)
    println(trapReducedTimeComplexity(intArrayOf(0, 1, 0, 2)))//T.C=> O(N), S.C=> O(N)
    println(trapReducedSpaceComplexity(intArrayOf(0, 1, 0, 2)))//T.C=> O(N), S.C=> O(1)
}

fun trapBruteForceIdea(A: IntArray): Int {
    var answer = 0
    for (i in A.indices) {
        var leftMax = A[i]
        var rightMax = A[i]

        for (j in 0..i)
            leftMax = maxOf(leftMax, A[j])
        for (j in i + 1..<A.size) {
            rightMax = maxOf(rightMax, A[j])
        }
        answer += minOf(leftMax, rightMax) - A[i]
    }
    return answer
}

fun trapReducedTimeComplexity(A: IntArray): Int {
    val N = A.size
    val leftMax = IntArray(N)
    val rightMax = IntArray(N)
    leftMax[0] = A[0]
    for (i in 1 until N) {
        leftMax[i] = maxOf(leftMax[i - 1], A[i])
    }
    rightMax[N - 1] = A[N - 1]
    for (i in (N - 2) downTo 0) {
        rightMax[i] = maxOf(rightMax[i + 1], A[i])
    }
    var answer = 0
    for (i in A.indices) {
        answer += minOf(leftMax[i], rightMax[i]) - A[i]
    }
    return answer
}

fun trapReducedSpaceComplexity(height: IntArray): Any {
    val N = height.size
    var i = 0
    var j = N - 1
    var leftMax = 0
    var rightMax = 0
    var answer = 0

    while (i <= j) {
        if (height[i] <= height[j]) {
            if (height[i] > leftMax) {
                leftMax = height[i]
            } else {
                answer += leftMax - height[i]
            }
            i++
        } else {
            if (height[j] > rightMax) {
                rightMax = height[j]
            } else {
                answer += rightMax - height[j]
            }
            j--
        }
    }
    return answer
}