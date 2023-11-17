package classes.scaler.interviewPreparation.codingProblems

import kotlin.math.abs
import kotlin.math.log10
import kotlin.math.pow

fun isArmstrongNumber(number: Int): Boolean {
    val numDigits = countDigits(number)
    var tempNumber = number
    var sum = 0

    while (tempNumber > 0) {
        val digit = tempNumber % 10
        sum += digit.toDouble().pow(numDigits).toInt()
        tempNumber /= 10
    }

    return sum == number
}

fun countDigits(number: Int): Int {
    return when (number) {
        0 -> 1
        else -> (log10(abs(number.toDouble())) + 1).toInt()
    }
}

/**
An Armstrong number (also known as a narcissistic number,
pluperfect digital invariant, or pluperfect number) is a number that
is the sum of its own digits each raised to the power of the number of digits.
For example, 153 is an Armstrong number because

1.pow(3)+5.pow(3)+3.pow(3) = 153.

Here's a Kotlin program to check if a given number is an Armstrong number in an efficient way:
 * */

fun main() {
    val number = 153 // Change this value to check for a different number
    if (isArmstrongNumber(number)) {
        println("$number is an Armstrong number.")
    } else {
        println("$number is not an Armstrong number.")
    }
}
