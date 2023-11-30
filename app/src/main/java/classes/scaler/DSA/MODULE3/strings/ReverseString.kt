package classes.scaler.DSA.MODULE3.strings

fun main() {
    println(reverseWholeString("the sky is blue").concatToString())

    val input = "the sky is blue"
    val output = reverseWords(input)
    val output1 = reverseWords1(input)
    println(output)
    println(output1)
}

fun reverseWholeString(str: String): CharArray {
    //Using Two pointers approach
    //Reverse string with n/2 swaps, so the time complexity is Big O(N).
    val list = str.toCharArray()

    var firstIndex = 0
    var lastIndex = list.size - 1
    while (firstIndex < lastIndex) {
        val temp = list[firstIndex]
        list[firstIndex] = list[lastIndex]
        list[lastIndex] = temp
        firstIndex += 1
        lastIndex -= 1
    }
    return list
}

fun reverseWords(input: String): String {
    val chars = input.toCharArray()

    // Helper function to reverse a portion of the character array
    fun reverse(start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }
    }

    // Reverse the entire character array
    reverse(0, chars.size - 1)

    var start = 0
    var end = 0

    while (end < chars.size) {
        if (chars[end].isWhitespace()) {
            // Reverse each word
            reverse(start, end - 1)
            start = end + 1
        }
        end++
    }

    // Reverse the last word
    reverse(start, chars.size - 1)

    return String(chars).trimStart().trimEnd()
}

fun reverseWords1(input: String): String {
    val result = StringBuilder()
    val currentWord = StringBuilder()

    for (char in input) {
        if (char.isWhitespace()) {
            if (currentWord.isNotEmpty()) {
                if (result.isNotEmpty()) {
                    result.insert(0, ' ')
                }
                result.insert(0, currentWord)
                currentWord.clear()
            }
        } else {
            currentWord.append(char)
        }
    }

    // Add the last word if the input string doesn't end with whitespace
    if (currentWord.isNotEmpty()) {
        if (result.isNotEmpty()) {
            result.insert(0, ' ')
        }
        result.insert(0, currentWord)
    }

    return result.toString()
}
