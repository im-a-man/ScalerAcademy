package classes.scaler.interviewPreparation.codingProblems

/*
1-> If a smaller numeral appears before a larger numeral,
subtract the smaller numeral from the larger numeral.
For example, IV represents 4 (5 - 1) and IX represents 9 (10 - 1).

2-> If a smaller numeral appears after a larger numeral,
add the smaller numeral to the larger numeral. For example,
VII represents 7 (5 + 2) and XII represents 12 (10 + 2).
*/

fun main() {

    val roman = "CCLXXXIII" // 287
    val roman1 = "CCLXXIV" // 274

    val romanNumeral = "MCMXCIV" // Example Roman numeral (1994)
    val intValue = romanToInt(romanNumeral)
    println("$romanNumeral in integer is $intValue")

    val romanValue = intToRoman(1994)
    println("1994 in roman is $romanValue")
}

fun romanToInt(s: String): Int {
    val romanMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    var result = 0
    var prevValue = 0
    for (i in s.indices.reversed()) {
        val currentChar = s[i]
        val currentValue = romanMap[currentChar] ?: 0
        if (currentValue < prevValue) {
            result -= currentValue
        } else {
            result += currentValue
        }
        prevValue = currentValue
    }
    return result
}

fun intToRoman(num: Int): String {
    val romanMap = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    var result = ""
    var remainder = num

    for ((value, symbol) in romanMap) {
        while (remainder >= value) {
            result += symbol
            remainder -= value
        }
    }

    return result
}