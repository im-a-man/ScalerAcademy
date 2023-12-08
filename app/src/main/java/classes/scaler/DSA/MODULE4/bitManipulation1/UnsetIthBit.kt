package classes.scaler.DSA.MODULE4.bitManipulation1

/**
Problem Description
You are given two integers A and B.
If B-th bit in A is set, make it unset.
If B-th bit in A is unset, leave as it is.
Return the updated A value.
Note:
The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.

Problem Constraints
1 <= A <= 109
0 <= B <= 30

Input Format
First argument A is an integer.
Second argument B is an integer.

Output Format
Return an integer.

Example Input
Input 1:
A = 4
B = 1
Input 2:
A = 5
B = 2

Example Output
Output 1:
4
Output 2:
1

Example Explanation
For Input 1:
Given N = 4 which is 100 in binary. The 1-st bit is already unset
For Input 2:
Given N = 5 which is 101 in binary. We unset the 2-nd bit
It becomes 001 which is 1 in Decimal.
 * */

fun main() {
    //First check if i-th bit is set => (N & (1<<i) != 0) then i-th bit is set, then
    //Use XOR operator to unset the i-th bit => N=(N^(1<<i)) - Toggle the i-th bit
    println(unSetTheBit(4, 1))
    println(unSetTheBit(5, 2))
}

fun unSetTheBit(A: Int, B: Int): Int {
    var A1 = A
    if ((A1 and (1 shl B)) != 0) {
        //Bit is set, so unset it or toggle it
        A1 = (A1 xor (1 shl B))
    } else {
        //Bit is already unset
    }
    return A1
}