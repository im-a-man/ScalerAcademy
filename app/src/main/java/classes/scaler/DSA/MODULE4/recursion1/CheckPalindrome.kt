package classes.scaler.DSA.MODULE4.recursion1

/**
Problem Description
Write a recursive function that checks whether string A is a palindrome or Not.
Return 1 if the string A is a palindrome, else return 0.
Note: A palindrome is a string that's the same when read forward and backward.

Problem Constraints
1 <= |A| <= 50000
String A consists only of lowercase letters.

Input Format
The first and only argument is a string A.

Output Format
Return 1 if the string A is a palindrome, else return 0.

Example Input
Input 1:
A = "naman"
Input 2:
A = "strings"

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
"naman" is a palindomic string, so return 1.
Explanation 2:
"strings" is not a palindrome, so return 0.
 * */

fun main() {
    println(isPalindrome("naman"))
}

fun isPalindrome(A: String): Int {
    return isPalindromeHelper(A, 0, (A.length - 1))
}

//A very large input can produce stack overflow error. so use 'tailrec' keyword
//It allows the compiler to optimize the recursion into an efficient loop,
//Preventing stack overflow errors.
tailrec fun isPalindromeHelper(
    s: String,
    start: Int,
    end: Int
): Int { // we need helper function because staring and ending index need to pass.
    if (start >= end) return 1
    return if (s[start] != s[end]) 0
    else isPalindromeHelper(s, start + 1, end - 1)
}