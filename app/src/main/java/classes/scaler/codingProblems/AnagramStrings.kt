package classes.scaler.interviewPreparation.codingProblems

import classes.GsonFactory.toJson

/*
Two strings called Anagram string if they have same characters and same characters count
Method 1=> Using Sorting, then match strings <= Not So good because T.C-(K(LogK))
Method 2=> Using Hashmap, then fill hashmap with count of each character T>C->O(N)
* */

fun main(args: Array<String>) {
//    val str1 = "EAT"
//    val str2 = "AET"
    val str1 = "ABAC"
    val str2 = "AABC"
    val result = isAnagramString(str1, str2)
    if (result) {
        println("The strings have the same characters. hence, these both are anagram strings.")
    } else {
        println("The strings do not have the same characters. hence, these both are not anagram strings.")
    }
}

fun isAnagramString(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) {//If length is different than strings never be same
        return false
    }
    val charCount: MutableMap<Char, Int> = HashMap()

    // Count character frequencies in str1.
    for (c in str1.toCharArray()) {
        charCount[c] = charCount.getOrDefault(c, 0) + 1
    }
    println(charCount.toJson())

    // Check if str2 has the same character frequencies.
    for (c in str2.toCharArray()) {
        val count = charCount.getOrDefault(c, 0)
        if (count == 0) {
            return false
        }
        charCount[c] = count - 1
    }
    println(charCount.toJson())
    return true
}