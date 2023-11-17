package classes.scaler.DSA.MODULE2.caryForwardAndSubArray

import com.google.gson.Gson

/*
Problem Description
You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array

Note : The order of the subarrays in the resulting 2D array does not matter.

Input Format
First argument A is an array of integers.

Output Format
Return a 2D array of integers in any order.
* */

//Generating all sub arrays
fun printAllSubArraysInARange(array: IntArray): Array<IntArray> {
    val arrayList = Array<IntArray>(array.size * (array.size + 1) / 2, init = { IntArray(it) })
    var j = 0
    for (sIndex in array.indices) {
        for (eIndex in sIndex until array.size) {
            arrayList[j] = printSubArray(array, sIndex, eIndex)
            j++
        }
    }
    return arrayList
}

//SubArray in given range
fun printSubArray(array: IntArray, sIndex: Int, eIndex: Int): IntArray {
    val intArray = IntArray(eIndex - sIndex + 1)
    for ((j, i) in (sIndex..eIndex).withIndex()) {
        intArray[j] = array[i]
    }
    return intArray
}

fun main(args: Array<String>) {
    val A = intArrayOf(5, 2, 1, 4)
    println(Gson().toJson(printAllSubArraysInARange(A)))

    val inputString = "abc"
    println("All sub-strings of '$inputString' are:")
    printSubStrings(inputString)
    val intArray = intArrayOf(1, 2, 3)
    println("All sub-arrays of ${intArray.contentToString()} are:")
    printSubArrays(intArray)
}

fun printSubStrings(input: String) {
    for (i in input.indices) {
        for (j in i + 1..input.length) {
            println(input.substring(i, j))
        }
    }
}

fun printSubArrays(arr: IntArray) {
    for (i in arr.indices) {
        for (j in i until arr.size) {
            for (k in i..j) {
                print("${arr[k]} ")
            }
            println()
        }
    }
}