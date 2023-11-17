package classes.scaler.interviewPreparation.codingProblems

/**
A palindrome number is a number that remains the same when
its digits are reversed. For example, 121, 1331, and 1221
are palindromic numbers. Here's a Kotlin program to check
if a given number is a palindrome:
* */

fun isPalindrome(number: Int): Boolean {
    var reversedNumber = 0

    var tempNumber = number
    while (tempNumber > 0) {
        val digit = tempNumber % 10
        reversedNumber = reversedNumber * 10 + digit
        tempNumber /= 10
    }

    return number == reversedNumber
}

fun main() {
    val number = 1221 // Change this value to check for a different number
    if (isPalindrome(number)) {
        println("$number is a palindrome number.")
    } else {
        println("$number is not a palindrome number.")
    }
}