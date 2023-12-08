package classes.scaler.DSA.MODULE4.bitManipulation1

/**
Problem Description
You are given two integers A and B.
Set the A-th bit and B-th bit in 0, and return output in decimal Number System.
Note:
The bit positions are 0-indexed, which means that the least significant bit (LSB) has index 0.

Problem Constraints
0 <= A <= 30
0 <= B <= 30

Input Format
First argument A is an integer.
Second argument B is an integer.

Output Format
Return an integer.

Example Input
Input 1:
A = 3
B = 5
Input 2:
A = 4
B = 4

Example Output
Output 1:
40
Output 2:
16

Example Explanation
For Input 1:
The binary expression is 101000 which is 40 in decimal.
For Input 2:
The binary expression is 10000 which is 16 in decimal
 * */

fun main() {
    println(solve(3, 5))
}

fun solve(A: Int, B: Int): Int {
    //To set the ith bit => N=(N|(1<<i))
    //Use OR operator to set the i-th bit

    //we are shifting or rasing power by 2 everytime we shift
    val posA = 1 shl A
    val posB = 1 shl B

    //with or we can set bits so using it
    var resutValue = posA or posB
    //return resutValue
    return ((0 or (1 shl A))) or ((0 or (1 shl B)))
}