package classes.scaler.DSA.MODULE3


/**
Problem Description
Given a number A, find if it is COLORFUL number or not.
If number A is a COLORFUL number return 1 else, return 0.
What is a COLORFUL Number:
A number can be broken into different consecutive sequence of digits.
The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
This number is a COLORFUL number, since the product of every consecutive sequence of digits is different

Problem Constraints
1 <= A <= 2 * 109

Input Format
The first and only argument is an integer A.

Output Format
Return 1 if integer A is COLORFUL else return 0.

Example Input
Input 1:
A = 23
Input 2:
A = 236

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
Possible Sub-sequences: [2, 3, 23] where
2 -> 2
3 -> 3
23 -> 6  (product of digits)
This number is a COLORFUL number since product of every digit of a sub-sequence are different.

Explanation 2:
Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
2 -> 2
3 -> 3
6 -> 6
23 -> 6  (product of digits)
36 -> 18  (product of digits)
236 -> 36  (product of digits)
This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
 * */

//Interview problems Q3 in Additional problems
//Need to see video solution for this
fun main() {
    println(colorful(236))
}

fun colorful(A: Int): Int {
    // Insert number A into array
    var A = A
    val ansArray: MutableList<Int> = ArrayList()
    // Insert the  number into ArrayList
    while (A > 0) {
        val digit = A % 10
        ansArray.add(digit)
        A /= 10
    }
    // Until here we have inserted the num into array in reverse order. Now we have to order the number as it is in the array
    // So to do that we have to reverse the number again
    var rev = 0
    while (A > 0) {
        val digit = A / 10
        rev = rev * 10 + digit
        A /= 10
    }
    // Now we have inserted the original number A into array
    val hashset = HashSet<Int>()
    // Take size of ansArray
    val N = ansArray.size
    for (i in 0 until N) {
        var product = 1
        for (j in i until N) {
            product *= ansArray[j]
            if (hashset.contains(product)) {
                return 0
            } else {
                hashset.add(product)
            }
        }
    }
    return 1
}