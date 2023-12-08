package classes.scaler.DSA.MODULE4.bitManipulation1

/**
Problem Description
Write a function that takes an integer and returns the number of 1 bits present in its binary representation.

Problem Constraints
1 <= A <= 109

Input Format
First and only argument contains integer A

Output Format
Return an integer

Example Input
Input 1:
11
Input 2:
6

Example Output
Output 1:
3
Output 2:
2

Example Explanation
Explaination 1:
11 is represented as 1011 in binary.
Explaination 2:
6 is represented as 110 in binary.
 * */

fun main() {
    println(countSetBits(11))
    println(countSetBits(6))
    println(countSetBits1(11))
    println(countSetBits1(6))
}

fun countSetBits(A: Int): Long {
    var ans: Long = 0
    var num = A
    while (num != 0) {
        num = num and (num - 1)
        ans++
    }
    return ans
}

fun countSetBits1(A: Int): Long {
    var ans: Long = 0
    var num = A
    while (num != 0) {
        if ((num and 1) == 1)
            ans++
        num = num shr 1
    }
    return ans
}