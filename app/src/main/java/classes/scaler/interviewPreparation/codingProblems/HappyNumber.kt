package classes.scaler.interviewPreparation.codingProblems

fun isHappyNumber(num: Int): Boolean {
    val seen = HashSet<Int>()  // To store the numbers we have seen to detect cycles
    var n = num

    while (n != 1 && n !in seen) {
        seen.add(n)
        var sum = 0
        while (n > 0) {
            val digit = n % 10 // To get the digit 1 by 1 from the last of a Number
            sum += digit * digit
            n /= 10 //Exclude the last digit from the number
        }
        n = sum
    }

    return (n == 1)
}

/*
A happy number is a positive integer that,
when repeatedly replaced with the sum of the squares of its digits,
eventually reaches the number 1. If it never reaches 1 and instead enters a cycle, it's not a happy number.

Here's an example of a happy number: 19
start N = 19
pow(1,2) + pow(9,2) = 1 + 81 = 82
pow(8,2) + pow(2,2) = 64 + 4 = 68
pow(6,2) + pow(8,2) = 36 + 64 = 100
pow(1,2) + pow(0,2) + pow(0,2) = 1 + 0 + 0 = "1", Hence 19 is Happy number
* */

fun main() {
    print("Enter a number: ")
    val num = readln().toInt()

    if (isHappyNumber(num)) {
        println("$num is a happy number.")
    } else {
        println("$num is not a happy number.")
    }
}