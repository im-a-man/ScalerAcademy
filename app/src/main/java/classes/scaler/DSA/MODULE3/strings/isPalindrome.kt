package classes.scaler.DSA.MODULE3.strings

fun isPalindrome(input: String): Boolean {
    val n = input.length

    // Check for an empty or single-character string
    if (n <= 1) {
        return true
    }

    // Helper function to expand around the center and get a palindromic substring
    fun expand(center: Int, length: Int): String {
        var left = center - length / 2
        var right = center + length / 2

        // If the length is odd, adjust the right index
        if (length % 2 == 0) {
            right--
        }

        while (left >= 0 && right < n) {
            if (input[left] == input[right]) {
                left--
                right++
            } else {
                break
            }
        }

        return input.substring(left + 1, right)
    }

    // Iterate through each character as a potential center of a palindrome
    for (center in 0 until n) {
        val oddPalindrome = expand(center, 1)
        val evenPalindrome = expand(center, 2)

        if (oddPalindrome.length == n || evenPalindrome.length == n) {
            return true
        }
    }

    return false
}

fun checkPalindrome(input: String): Boolean {
    var left = 0
    var right = input.length - 1
    while (left < right) {
        if (input[left] != input[right])
            return false
        left++
        right--
    }
    return true
}

fun main() {
    val input = "madam"
    val result = isPalindrome(input)
    val result1 = checkPalindrome(input)

    if (result) {
        println("The string is a palindrome.")
    } else {
        println("The string is not a palindrome.")
    }
    if (result1) {
        println("The string is a palindrome.")
    } else {
        println("The string is not a palindrome.")
    }
}