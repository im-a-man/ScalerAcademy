package classes.scaler.DSA.MODULE3.interviewProblems

/**
Problem Description
Given an array of size N, find the majority element.
The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.

Problem Constraints
1 <= N <= 5*105
1 <= num[i] <= 109

Input Format
Only argument is an integer array.

Output Format
Return an integer.

Example Input
Input 1:
[2, 1, 2]
Input 2:
[1, 1, 1]

Example Output
Input 1:
2
Input 2:
1

Example Explanation
For Input 1:
2 occurs 2 times which is greater than 3/2.
For Input 2:
1 is the only element in the array, so it is majority
 * */

fun main() {
    println(checkingAndVerifyingMajorityElement(intArrayOf(2, 2, 1, 1, 1)))//Right program for N/2
}

// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
//For a number to be in majority, it has to be present more than n/2
// since it occupies more than half,there will be a large patches of
//consecutive presence of that element
//moores alorithm does exactly that,
//select any element,start traversing increase its count when you found it
// decerase when different element is found
// if count becomes 0, it means we have a new element that outnumbers the current
//elected element tgat we thought to be in majority,so it cant be in majority
// select the current element and do the same process
fun findMajorityElement(A: IntArray, n: Int): Int {
    var majorityElement = A[0]
    var frequency = 1
    for (i in 1 until n) {
        if (frequency == 0) {
            majorityElement = A[i]
            frequency = 1
        } else if (majorityElement == A[i]) {
            frequency++
        } else {
            frequency--
        }
    }
    return majorityElement
}

fun checkingAndVerifyingMajorityElement(A: IntArray): Int {
    val n = A.size

    //Finding the majority element
    val majorityElement = findMajorityElement(A, n)

    //Verifying the majority element
    var frequency = 0
    for (i in 0 until n) {
        if (A[i] == majorityElement) frequency++
    }

    val threshold = n / 2
    return if (frequency > threshold) majorityElement else -1
}
