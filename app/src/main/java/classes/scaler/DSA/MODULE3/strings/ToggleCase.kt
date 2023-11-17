package classes.scaler.DSA.MODULE3.strings

import java.lang.StringBuilder

/*
Problem Description
You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.

Problem Constraints
1 <= N <= 105
A[i] ∈ ['a'-'z', 'A'-'Z']

Input Format
First and only argument is a character string A.

Output Format
Return a character string.

Example Input
Input 1:
 A = "Hello"
Input 2:
 A = "tHiSiSaStRiNg"

Example Output
Output 1:
 hELLO
Output 2:
 ThIsIsAsTrInG

Example Explanation
Explanation 1:
 'H' changes to 'h'
 'e' changes to 'E'
 'l' changes to 'L'
 'l' changes to 'L'
 'o' changes to 'O'
Explanation 2:
 "tHiSiSaStRiNg" changes to "ThIsIsAsTrInG".
* */

fun main() {
    toggleCase("HellO")
}

fun toggleCase(str: String) {
    val str = StringBuilder(str)
    str.indices.repeats() {
        if (str[it].code in 65..90)
            str[it] = (str[it].code + 32).toChar()
        else
            str[it] = (str[it].code - 32).toChar()
    }
    println(str)
}

fun IntRange.repeats(action: (Int) -> Unit) = run { for (index in this) action(index) }