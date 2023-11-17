package classes.scaler.DSA.MODULE3.bitManipulationsBasics

/*
Problem Description
Given two binary strings A and B. Return their sum (also a binary string).

Problem Constraints
1 <= length of A <= 105
1 <= length of B <= 105
A and B are binary strings

Input Format
The two argument A and B are binary strings.

Output Format
Return a binary string denoting the sum of A and B

Example Input
Input 1:
A = "100"
B = "11"
Input 2:
A = "110"
B = "10"

Example Output
Output 1:
"111"
Output 2:
"1000"

Example Explanation
For Input 1:
The sum of 100 and 11 is 111.
For Input 2:
The sum of 110 and 10 is 1000.
* */

fun main() {
    println(addBinary("100","11"))
    println(addBinary("110","10"))
}

fun addBinary(A: String, B: String): String {
    val sb = StringBuilder()
    var i = A.length - 1
    var j = B.length - 1
    var carry = 0
    while (i >= 0 || j >= 0) {
        var sum = carry
        if (i >= 0) sum += A[i--].code - '0'.code
        if (j >= 0) sum += B[j--].code - '0'.code
        sb.append(sum % 2)
        carry = sum / 2
    }
    if (carry != 0) sb.append(carry)
    return sb.reverse().toString()
}