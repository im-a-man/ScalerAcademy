package classes.scaler.DSA.MODULE2.caryForwardAndSubArray

/*
Problem Description
You have given a string A having Uppercase English letters.
You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.

Input Format
First and only argument is a string A.

Output Format
Return an integer denoting the answer.

Example Input
Input 1:
 A = "ABCGAG"
Input 2:
 A = "GAB"

Example Output
Output 1:
 3
Output 2:
 0
* */

fun main() {
    //NOTE: Return the answer modulo 10 ki pow(9) + 7 as the answer can be very large.
    val A = "ABCGAG"
    var countA = 0
    var ans = 0L
    val MOD=1000000007L
    for (i in A.indices) {
        if (A[i] == 'A')
            countA += 1
        if (A[i] == 'G')
            ans += countA
    }
    println((ans%MOD).toInt())
}