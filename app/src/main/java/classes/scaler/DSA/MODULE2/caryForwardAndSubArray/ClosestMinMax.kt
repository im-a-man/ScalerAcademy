package classes.scaler.DSA.MODULE2.caryForwardAndSubArray

/*
Problem Description
Given an array A, find the size of the smallest subArrays such that
it contains at least one occurrence of the maximum value of the array
and at least one occurrence of the minimum value of the array.

Input Format
First and only argument is vector A

Output Format
Return the length of the smallest subarray which has at
least one occurrence of minimum and maximum element of the array
* */

fun main() {
    val A = intArrayOf(2, 6, 1, 6, 9)//Answer is 3
    println(countSmallestSubArraysWithMinAndMax(A))
}

fun countSmallestSubArraysWithMinAndMax(array: IntArray): Int {
    val (overallMin, overallMax) = findMinAndMax(array)
    var (indexOfMin, indexOfMax) = Pair(-1, -1)
    var count = array.size
    for (i in array.size - 1 downTo 0) {
        if (array[i] == overallMax) {
            indexOfMax = i
            if (indexOfMin != -1) {
                count = minOf(count, indexOfMin - indexOfMax + 1)
            }
        }
        if (array[i] == overallMin) {
            indexOfMin = i
            if (indexOfMax != -1) {
                count = minOf(count, indexOfMax - indexOfMin + 1)
            }
        }
    }
    return count
}

fun findMinAndMax(array: IntArray): Pair<Int, Int> {
    if (array.isEmpty()) {
        throw IllegalArgumentException("Array is empty")
    }
    var min = array[0]
    var max = array[0]
    for (element in array) {
        if (element < min) {
            min = element
        }
        if (element > max) {
            max = element
        }
    }
    return Pair(min, max)
}
