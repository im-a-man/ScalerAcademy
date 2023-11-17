package classes.scaler.DSA.MODULE3

/**
Problem Description
You're given a read-only array of N integers.
Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.
If there are multiple solutions, return any one.
Note: Read-only array means that the input array should not be modified in the process of solving the problem

Problem Constraints
1 <= N <= 7*105
1 <= A[i] <= 109

Input Format
The only argument is an integer array A.

Output Format
Return an integer.

Example Input
Input 1:
[1 2 3 1 1]
Input 2:
[1 2 3]

Example Output
Output 1:
1
Output 2:
-1

Example Explanation
Explanation 1:
1 occurs 3 times which is more than 5/3 times.
Explanation 2:
No element occurs more than 3 / 3 = 1 times in the array.
* */

//Same as majority elements but here is N/3, so we can remove 3 distinct elements
fun main() {
    println(repeatedNumber(intArrayOf(1, 1, 1, 2, 3, 5, 7)))//Wrong program for N/3
}
//boyer moore voting algorithm
fun repeatedNumber(A: IntArray): Int {
    //First finding the majority elements
    val n = A.size
    var c1 = 0
    var c2 = 0
    var num1 = -1 // first majority element
    var num2 = -1 //second majority element
    for (i in 0 until n) {
        val ele = A[i]
        if (ele == num1) {
            c1++
        } else if (ele == num2) {
            c2++
        } else if (c1 == 0) {
            num1 = ele
            c1 = 1
        } else if (c2 == 0) {
            num2 = ele
            c2 = 1
        } else {
            c1--
            c2--
        }
    }

    //Then checking and verifying the majority elements
    var num1Count = 0 //storing count of first majority element
    var num2Count = 0 //storing count of second majority element
    for (i in 0 until n) {
        if (A[i] == num1) {
            num1Count++
        }
        if (A[i] == num2) {
            num2Count++
        }
    }

    //Then returning the answers accordingly
    if (num1Count > n / 3) {
        return num1
    } else if (num2Count > n / 3) {
        return num2
    }
    return -1
}