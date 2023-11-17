package classes.scaler.DSA.MODULE2.caryForwardAndSubArray

import classes.scaler.GsonFactory.toJson

/*
Problem Description
Given an integer array A containing N distinct integers,
you have to find all the leaders in array A.
An element is a leader if it is strictly greater than all the elements to its right side.
NOTE: The rightmost element is always a leader.

Input Format
There is a single input argument which a integer array A
Example Input
Input 1:
 A = [16, 17, 4, 3, 5, 2]
Input 2:
 A = [5, 4]

Output Format
Return an integer array denoting all the leader elements of the array.
Example Output
Output 1:
[17, 2, 5]
Output 2:
[5, 4]
* */

fun main() {
    val A = intArrayOf(16, 17, 4, 3, 5, 2)

    var rightMax = A[A.size - 1]
    val leaderElements = arrayListOf<Int>()
    leaderElements.add(rightMax)
    for (i in (A.size - 2) downTo 0) {
        if (A[i] > rightMax) {
            rightMax = A[i]
            leaderElements.add(A[i])
        }
    }
    println(leaderElements.toJson())
}