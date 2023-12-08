package classes.scaler.DSA.MODULE4.bitManipulation1

import kotlin.math.pow


/**
Problem Description
Given an integer A, find and return the Ath magic number.
A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

Problem Constraints
1 <= A <= 5000

Input Format
The only argument given is integer A.

Output Format
Return the Ath magic number.

Example Input
Example Input 1:
A = 3
Example Input 2:
A = 10

Example Output
Example Output 1:
30
Example Output 2:
650

Example Explanation
Explanation 1:
Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
3rd element in this is 30
Explanation 2:
In the sequence shown in explanation 1, 10th element will be 650.
 * */

fun main() {
    println(magicNumber(10))
}

fun magicNumber(A: Int): Int {
    //tc = 0(32) //bit size
    //sc = 0(1)
    //magic number = 5,25,30(5+25),125,130(125+5)
    //magic number is getting the binary of nth number 3(11) ,check set  = 5^2+5^1
    var A = A
    var ans = 0
    var powIndex = 1 //consider as +ve powIndex
    while (A > 0) {
        //check if oth bit set or not if set then we go for  pow(5,index);
        if ((A and 1) == 1) {
            // adding the 5 * pow of current  in ans ,
            ans += Math.pow(5.0, powIndex.toDouble()).toInt()
        }
        powIndex++ //pow value will ++ in each itteration
        A = A shr 1 //right shift for making oth bit as set bit.
    }
    return ans
}