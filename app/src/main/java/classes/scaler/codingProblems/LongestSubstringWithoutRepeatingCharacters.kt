package classes.scaler.interviewPreparation.codingProblems

/*
* To find the length of the longest substring without repeating characters in Kotlin,
* you can use a sliding window approach.
* */
fun main() {
    val input = "abcabcbb"
    /*
    This example would output 3 because the longest substring
    without repeating characters in "abcabcbb" is "abc".
    * */

    val result = lengthOfLongestSubstring(input)
    println("Length of the longest substring without repeating characters: $result")
}


fun lengthOfLongestSubstring(s: String): Int {
    val charIndexMap = mutableMapOf<Char, Int>()
    var maxLength = 0
    var start = 0

    for (end in s.indices) {
        if (charIndexMap.containsKey(s[end])) {
            // Move the start pointer to the right of the previous occurrence
            start = maxOf(start, charIndexMap[s[end]]!! + 1)
        }

        // Update the index of the current character
        charIndexMap[s[end]] = end

        // Update the maximum length
        maxLength = maxOf(maxLength, end - start + 1)
    }

    return maxLength
}

/**
 * Here's an explanation of how the function works:
 *
 * 1=> Initialization:
 * charIndexMap is a mutable map that stores the index of each character's last occurrence.
 * maxLength keeps track of the maximum length of the substring without repeating characters.
 * start is the start index of the current substring.
 *
 * 2=> Iterating through the String:
 * The function uses a sliding window defined by the start and end pointers.
 *
 * 3=> Checking for Repeating Characters:
 * If the current character is already in the charIndexMap, it means there is a repeating character.
 * In such cases, the start pointer is moved to the right of the previous occurrence of the character.
 *
 * 4=> Updating the Index:
 * The index of the current character is updated in the charIndexMap.
 *
 * 5=> Updating the Maximum Length:
 * The maximum length is updated based on the current length of the substring.
 *
 * 6=> Completing the Iteration:
 * The loop continues until the end pointer reaches the end of the string.
 *
 * Note=>
 * The sliding window approach allows the algorithm to efficiently
 * find the length of the longest substring without repeating characters.
* */