package classes.scaler.DSA.MODULE2.caryForwardAndSubArray

/*
Find maximum product sub-array
* */

fun main() {
    println(maxProductSubArray(intArrayOf(2, 3, 0, -2, 4)))
    println(maxProductSubArray(intArrayOf(2, 3, -2, 4)))
}

fun maxProductSubArray(array: IntArray): Int {
    var prefix = 1
    var suffix = 1
    var answer = Int.MIN_VALUE
    val N = array.size
    for (i in 0 until N) {
        if (prefix == 0) prefix = 1
        if (suffix == 0) suffix = 1

        prefix *= array[i]
        suffix *= array[N - i - 1]//Run from back towards front
        answer = maxOf(answer, maxOf(prefix, suffix))
    }
    return answer
}