package classes.scaler.DSA.MODULE4.bitManipulation1

/**
Problem Description
Alex and Sam are good friends. Alex is doing a lot of programming these days.
He has set a target score of A for himself.
Initially, Alex's score was zero. Alex can double his score by doing a question,
or Alex can seek help from Sam for doing questions that will contribute 1 to Alex's score.
Alex wants his score to be precisely A. Also, he does not want to take much help from Sam.
Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of A.

Problem Constraints
0 <= A <= 10^9

Input Format
The only argument given is an integer A.

Output Format
Return the minimum number of times help taken from Sam.

Example Input
Input 1:
A = 5
Input 2:
A = 3

Example Output
Output 1:
2
Output 2:
2

Example Explanation
Explanation 1:
Initial score : 0
Takes help from Sam, score : 1
Alex solves a question, score : 2
Alex solves a question, score : 4
Takes help from Sam, score: 5

Explanation 2:
Initial score : 0
Takes help from Sam, score : 1
Alex solves a question, score : 2
Takes help from Sam, score : 3
 * */

fun main() {
    println(needNthTimesHelp(5))
    println(needNthTimesHelp1(5))
}

fun needNthTimesHelp(A: Int): Int {
    var A = A
    var countSetBits = 0
    while (A != 0) {
        if (A and 1 == 1) {//Increment counter if LSB is 1
            countSetBits++
        }
        A = A shr 1// Right shift A to check the next bit
    }
    return countSetBits
}

/*
    Q: Alex has a target to achieve by solving questions:
        1. He solve a question by himself he get 2 points,
        2. He solve a question by taking sam's help then he get only 1 point.

    Now, we just have to calculate the number of helps taking by the Alex from sam.

    ANS: We have a number A:
        1. If A is odd then we subtract 1,
        2. If A is even we divide by 2.
        ... Untill we hit 0.
*/

/*
    Q: Alex has a target to achieve by solving questions:
        1. He solve a question by himself he get 2 points,
        2. He solve a question by taking sam's help then he get only 1 point.

    Now, we just have to calculate the number of helps taking by the Alex from sam.

    ANS: We have a number A:
        1. If A is odd then we subtract 1,
        2. If A is even we divide by 2.
        ... Untill we hit 0.
*/
fun needNthTimesHelp1(A: Int): Int {
    var A = A
    var samHelp = 0
    while (A > 0) {

        // Normal Operation With Arithmetic Operator : - (Subtraction)
        // if (A % 2 != 0) {
        //     A -= 1;
        //     samHelp++;
        // }

        // Normal Operation With Arithmetic Operator : / (Division)
        // else if (A % 2 == 0) {
        //     A /= 2;
        // }

        // Here we just toggle the first-bit (0th bit) from 1(set) to 0(unset), because every odd number has 0th bit as set.
        if (A % 2 != 0) {
            A = A xor 1
            samHelp++
        } else { // (A % 2) == 0
            A = A shr 1
        }
    }
    return samHelp
}