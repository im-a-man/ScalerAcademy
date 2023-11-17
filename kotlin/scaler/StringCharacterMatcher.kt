package classes.scaler

import classes.scaler.GsonFactory.toJson


object StringCharacterMatcher {
    fun haveSameCharacters(str1: String, str2: String): Boolean {
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
}