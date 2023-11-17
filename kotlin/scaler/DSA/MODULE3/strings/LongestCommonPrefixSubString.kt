package classes.scaler.DSA.MODULE3.strings

/*
Problem Description
Given the array of strings A, you need to find the longest string S,
which is the prefix of ALL the strings in the array.
The longest common prefix for a pair of strings S1 and S2 is the
longest string S which is the prefix of both S1 and S2.
Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
Problem Constraints
0 <= sum of length of all strings <= 1000000

Input Format
The only argument given is an array of strings A.

Output Format
Return the longest common prefix of all strings in A.

Example Input
Input 1:
A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:
A = ["abab", "ab", "abcd"];

Example Output
Output 1:
"a"
Output 2:
"ab"

Example Explanation
Explanation 1:
Longest common prefix of all the strings is "a".
Explanation 2:
Longest common prefix of all the strings is "ab".
* */

fun main() {
    println(longestCommonPrefix(arrayOf("abab", "ab", "abcd")))
}

fun longestCommonPrefix(A: Array<String>): String? {
    //First Solution come to my mind
    var min = A[0].length
    //first calculated minimum length string
    for (i in 1 until A.size) {
        if (A[i].length < min) {
            min = A[i].length
        }
    }
    // then iterated over the string array for each string comparing min no characters and updating the min as it decreasses
    for (i in 0 until A.size - 1) {
        var k = 0
        for (j in 0 until min) { //checking till smallest string in the array
            if (A[i][j] == A[i + 1][j]) {
                k++
            }
        }
        min = k
    }
    return if (min == 0) "" else A[0].substring(0, min)
}