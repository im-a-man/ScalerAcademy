package classes.scaler.DSA.MODULE4.interviewProblems

/**
Problem Description
Given an unsorted integer array, A of size N. Find the first missing positive integer.
Note: Your algorithm should run in O(n) time and use constant space.

Problem Constraints
1 <= N <= 1000000
-109 <= A[i] <= 109

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the first missing positive integer.

Example Input
Input 1:
[1, 2, 0]
Input 2:
[3, 4, -1, 1]
Input 3:
[-8, -7, -6]

Example Output
Output 1:
3
Output 2:
2
Output 3:
1

Example Explanation
Explanation 1:
A = [1, 2, 0]
First positive integer missing from the array is 3.
Explanation 2:
A = [3, 4, -1, 1]
First positive integer missing from the array is 2.
Explanation 3:
A = [-8, -7, -6]
First positive integer missing from the array is 1.
 * */

fun main() {
    println(firstMissingPositive(intArrayOf(1, 2, 0)))
    println(firstMissingPositive(intArrayOf(3, 4, -1, 1)))
    println(firstMissingPositive(intArrayOf(-8, -7, -6)))
}

fun firstMissingPositive(A: IntArray): Int {
    //first place all the elements at their valid index, neglecting negatives and out of range elements
    for (i in A.indices) {
        while (A[i] != (i + 1) && (A[i] in 1..A.size)) {
            val value = A[i]
            if (A[i] == A[value - 1])//For handling duplicates
                break
            //Swap A[i] with A[value-1]
            val temp = A[i]
            A[i] = A[value - 1]
            A[value - 1] = temp
        }
    }
    //Then
    for (i in A.indices) {
        if (A[i] != (i + 1))
            return i + 1
    }
    return (A.size + 1)
}