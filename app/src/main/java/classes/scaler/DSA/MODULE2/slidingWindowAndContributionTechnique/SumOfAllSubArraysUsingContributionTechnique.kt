package classes.scaler.DSA.MODULE2.slidingWindowAndContributionTechnique

/*
Problem Description
You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part
of an array which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.

Note : Be careful of integer overflow issues while calculations. Use appropriate datatypes.

Problem Constraints
1 <= N <= 105
1 <= Ai <= 10 4

Input Format
The first argument is the integer array A.
Output Format
Return a single integer denoting the sum of all subarray sums of the given array.

Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [2, 1, 3]

Example Output
Output 1:
20
Output 2:
19

Example Explanation
Explanation 1:
The different subarrays for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20
Explanation 2:
The different subarrays for the given array are: [2], [1], [3], [2, 1], [1, 3], [2, 1, 3].
Their sums are: 2 + 1 + 3 + 3 + 4 + 6 = 19
* */

fun main() {
    println(subArraySum(intArrayOf(1, 2, 3)))
    println(subArraySum(intArrayOf(2, 1, 3)))
}

//Sum of all sub arrays use contribution technique
fun subArraySum(A: IntArray): Int {
    val N = A.size
    var ans = 0
    for (i in A.indices) {
        val contribution = A[i] * ((i + 1) * (N - i))
        ans += contribution
    }
    /**
    * So to find the contribution of an element in all sub array sum is
     * We've to check the options for start index and options for end index and multiply them
     *
     * Like To find the contribution of i element
     * options for start index for i is => [0,i] => [i - 0 + 1] => (i+1)
     * options for end index for i is => [i,N-1] => [(N-1) - i + 1] => (N-i)
     * Now multiplies the options with element to find the contribution of i element
     * (iElement * (i+1) * (N-i)) and add all the element's contribution to ans
    * */
    return ans
}