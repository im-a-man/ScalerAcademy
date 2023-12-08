package classes.scaler.DSA.MODULE3.strings

import classes.GsonFactory.toJson


/*
Problem Description
Given a string A of size N, find and return the longest palindromic substring in A.
Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
Incase of conflict, return the substring which occurs first ( with the least starting index).

Problem Constraints
1 <= N <= 6000

Input Format
First and only argument is a string A.

Output Format
Return a string denoting the longest palindromic substring of string A.

Example Input
Input 1:
A = "aaaabaaa"
Input 2:
A = "abba"

Example Output
Output 1:
"aaabaaa"
Output 2:
"abba"

Example Explanation
Explanation 1:
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
Explanation 2:
We can see that longest palindromic substring is of length 4 and the string is "abba".
* */

fun main() {
    val input = "aaaabaaa"
    //val input = "abba"
    println("Longest Palindromic substring is : ${longestPalindromicSubstring(input)}")
    println("Count of all Palindromic substrings is : ${countAllPalindromicSubstring(input)}")
    println("All Palindromic substrings are : ${getAllPalindromicSubstrings(input).toJson()}")
}

fun longestPalindromicSubstring(input: String): String {
    fun expand(input: String, left: Int, right: Int): String {
        var l = left//left
        var r = right//right

        while (l >= 0 && r < input.length) {
            if (input[l] == input[r]) {
                l--
                r++
            } else
                break
        }
        //return (r - l - 1) //returning max length of palindromic substring
        return input.substring(l + 1, r)//returning palindromic substring
    }

    var maxLengthSubString = ""
    for (i in input.indices) {
        val oddPalindrome = expand(input, i - 1, i + 1)
        val evenPalindrome = expand(input, i, i + 1)

//        maxOf(maxLengthSubString, oddPalindrome, evenPalindrome)
        var greater = oddPalindrome
        if (greater.length < evenPalindrome.length) {
            greater = evenPalindrome
        }
        if (greater.length > maxLengthSubString.length) {
            maxLengthSubString = greater
        }
    }
    return maxLengthSubString
}

fun countAllPalindromicSubstring(input: String): Any {
    val n = input.length

    // Check for an empty or single-character string
    if (n <= 1) {
        return input
    }

    fun expand(center: Int, length: Int): Int {
        var left = center - length / 2
        var right = center + length / 2

        // If the length is odd, adjust the right index
        if (length % 2 == 0) {
            right--
        }

        var count = 0
        while (left >= 0 && right < n) {
            if (input[left] == input[right]) {
                count += 1//Count each palindromic substring within a range
                left--
                right++
            } else
                break
        }
        return count // return total count of palindromic substring within a range
    }

    var totalCount = 0
    for (center in 0..<n) {
        // Count both odd and even palindromes centered at index 'center'
        totalCount += expand(center, 1) + expand(center, 2)
    }
    return totalCount
}

fun getAllPalindromicSubstrings(input: String): List<String> {
    val n = input.length

    // Check for an empty or single-character string
    if (n <= 1) {
        return listOf(input)
    }

    fun expand(center: Int, length: Int): List<String> {
        var left = center - length / 2
        var right = center + length / 2

        // If the length is odd, adjust the right index
        if (length % 2 == 0) {
            right--
        }

        val palindromes = mutableListOf<String>()
        while (left >= 0 && right < n) {
            if (input[left] == input[right]) {
                palindromes.add(input.substring(left, right + 1))
                left--
                right++
            } else {
                break
            }
        }
        return palindromes
    }

    val allPalindromes = mutableListOf<String>()
    for (center in 0 until n) {
        // Add both odd and even palindromes centered at index 'center'
        allPalindromes.addAll(expand(center, 1))
        allPalindromes.addAll(expand(center, 2))
    }
    return allPalindromes
}
