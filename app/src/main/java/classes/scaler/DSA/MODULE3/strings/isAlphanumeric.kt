package classes.scaler.DSA.MODULE3.strings

/**
Problem Description
You are given a function isalpha() consisting of a character array A.
Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.

Problem Constraints
1 <= |A| <= 105

Input Format
Only argument is a character array A.
Output Format
Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.

Example Input
Input 1:
A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
Input 2:
A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']

Example Output
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
All the characters are alphanumeric.
Explanation 2:
All the characters are NOT alphabets i.e ('#').
 * */

fun main() {
    println(
        isAlpha(
            arrayOf('S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0')
        )
    )
}

fun isAlpha(arr: Array<Char>): Int {
    var isAlpha = 1
    arr.forEach {
        if (it !in 'A'..'Z' && it !in 'a'..'z' && it !in '0'..'9') {
            isAlpha = 0
        }
    }
    /*arr.forEach {
        isAlpha = when (it) {
            !in 65..90, !in 97..122, !in 48..57 -> {
                0
            }
            !in 'A'..'Z', !in 'a'..'z', !in '0'..'9' -> {
                0
            }
        }
    }*/
    return isAlpha
}