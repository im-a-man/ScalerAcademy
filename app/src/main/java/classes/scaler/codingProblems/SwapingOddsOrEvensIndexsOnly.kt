package classes.scaler.interviewPreparation.codingProblems

import classes.GsonFactory.toJson

fun main() {
    println(swapOddEvenElements().toJson())
    println(reverseAString().toJson())
    println(reverseNumbersArray().toJson())
}

fun swapOddEvenElements(): ArrayList<Int> {
    val list = arrayListOf<Int>(8, 1, 4, 3, 9, 6, 2, 7)
//    [8, 1, 4, 3, 9, 6, 2, 7]
//    [0, 1, 2, 3, 4, 5, 6, 7]
//    [8, 7, 4, 6, 9, 3, 2, 1] // Swapping odd indexes only
//    [2, 1, 9, 3, 4, 6, 8, 7] // Swapping even indexes only

    var firstIndex = 0
    var lastIndex = list.size - 1
    while (firstIndex < lastIndex) {
        if (firstIndex % 2 == 0) {//Skipping even indexes
            firstIndex += 1
        } else if (lastIndex % 2 == 0) {//Skipping even indexes
            lastIndex -= 1
        } else {
            val temp = list[firstIndex]
            list[firstIndex] = list[lastIndex]
            list[lastIndex] = temp
            firstIndex += 1
            lastIndex -= 1
        }
    }
    return list
}

fun reverseNumbersArray(): ArrayList<Int> {
    val list = arrayListOf<Int>(8, 1, 4, 3, 9, 6, 2, 7)
//    [8, 1, 4, 3, 9, 6, 2, 7]
//    [7, 2, 6, 9, 3, 4, 1, 8]

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

fun reverseAString(): CharArray {
    //Using Two pointers approach
    //Reverse string with n/2 swaps, so the time complexity is Big O(N).
    val str = "abcdef"
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
    println(list.concatToString())
    return list
}