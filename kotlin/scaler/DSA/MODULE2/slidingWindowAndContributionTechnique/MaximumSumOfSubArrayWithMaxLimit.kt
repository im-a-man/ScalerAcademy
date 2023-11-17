package classes.scaler.DSA.MODULE2.slidingWindowAndContributionTechnique

/*
Problem Description
You are given an integer array C of size A.
Now you need to find a subarray (contiguous elements)
so that the sum of contiguous elements is maximum.
But the sum must not exceed B.

Input Format
The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.

Output Format
Return a single integer which denotes the maximum sum.

Example Input
Input 1:
A = 5
B = 12
C = [2, 1, 3, 4, 5]
Input 2:
A = 3
B = 1
C = [2, 2, 2]

Example Output
Output 1:
12
Output 2:
0

Example Explanation
Explanation 1:
We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
Explanation 2:
All elements are greater than B, which means we cannot select any subarray.
Hence, the answer is 0.
* */

fun main() {
    println(maxSubArrayWithLimit(5, 12, intArrayOf(2, 1, 3, 4, 5)))
    println(maxSubArrayUsingKadaneAlgo(5, 12, intArrayOf(2, 1, 3, 4, 5)))
    println(maxSubArrayUsingKadaneAlgo(8, 12, intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)))//7
    println("--------------------------------")
    println(maxSubArrayWithLimit(3, 1, intArrayOf(2, 2, 2)))
    println(maxSubArrayUsingKadaneAlgo(3, 1, intArrayOf(2, 2, 2)))
}

fun maxSubArrayWithLimit(A: Int, B: Int, C: IntArray): Int {
    var ans = 0
    for (i in 0 until A) {
        var sum = 0
        for (j in i until A) {
            sum += C[j]
            if (sum <= B)
                ans = Math.max(ans, sum)
            else break;
        }
    }
    return ans
}

//Kadane's Algorithms
//https://www.youtube.com/watch?v=YxuK6A3SvTs&list=PLEJXowNB4kPwCPVjDv6KsAsThtDOCQUok&index=3
fun maxSubArrayUsingKadaneAlgo(A: Int, B: Int, C: IntArray): Int {
    //2, 1, 3, 4, 5
    var maxEnd = 0
    var maxSoFar = Int.MIN_VALUE
    var leftIndex = 0
    var rightIndex = 0

    for (i in 0 until A) {
        maxEnd += C[i]
        if (maxEnd < C[i]) {
            maxEnd = C[i]
            leftIndex = i
        }
        if (maxSoFar < maxEnd) {
            maxSoFar = maxEnd
            rightIndex = i
        }
    }
    println("SubArray from $leftIndex to $rightIndex")
    return maxSoFar
}