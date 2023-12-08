package classes.scaler.DSA.MODULE2.prefixSumArray

import classes.GsonFactory.toJson

//First we have prefixSum Array okay
//Then we need to find the sum of original arrays using prefix sum
//so we have index ranges l, r

//CREATE PREFIX ARRAYs
//for (i in 1 until A.size)
//        A[i] = A[i - 1] + A[i] //The prefix sum formula

//Example=>

//Given the prefix sum of an array, prefSum = [-2, 4, 1, 5, 2]
//What is the sum of the original array from index 1 to 2 (0-based) ?

//Answer=> sum[L,R] = prefixSum[R] - prefixSum[L-1]

//So answer is = 1 - (-2) = 3

fun main() {
    //Prefix Sum within same array
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (i in 1 until array.size)
        array[i] = array[i - 1] + array[i]
    println("prefixSum within same array =>\n" + array.toJson())

    val array1 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    array1.prefixSum()
    array1.suffixSum()
    array1.prefixProduct()
    array1.suffixProduct()
}

fun IntArray.prefixSum(): IntArray {
    val array = this
    val N = array.size
    val prefixSum = IntArray(N)
    prefixSum[0] = array[0]
    for (i in 1 until N)
        prefixSum[i] = prefixSum[i - 1] + array[i]
    println("prefixSum =>\n" + prefixSum.toJson())

    return prefixSum
}

fun IntArray.suffixSum(): IntArray {
    val array = this
    val N = array.size
    val suffixSum = IntArray(N)
    suffixSum[N - 1] = array[N - 1]
    for (i in N - 2 downTo 0)
        suffixSum[i] = suffixSum[i + 1] + array[i]
    println("suffixSum =>\n" + suffixSum.toJson())

    return suffixSum
}

fun IntArray.prefixProduct(): IntArray {
    val array = this
    val N = array.size
    val prefixProduct = IntArray(N)
    prefixProduct[0] = array[0]
    for (i in 1 until N)
        prefixProduct[i] = prefixProduct[i - 1] * array[i]//Within another array
    println("prefixProduct =>\n" + prefixProduct.toJson())

    return prefixProduct
}

fun IntArray.suffixProduct(): IntArray {
    val array = this
    val N = array.size
    val suffixProduct = IntArray(N)
    suffixProduct[N - 1] = array[N - 1]
    for (i in N - 2 downTo 0)
        suffixProduct[i] = suffixProduct[i + 1] * array[i]
    println("suffixProduct =>\n" + suffixProduct.toJson())

    return suffixProduct
}

enum class CumulativeMode(val mode: String) {
    PREFIX_SUM("PREFIX_SUM"),
    SUFFIX_SUM("SUFFIX_SUM"),
    PREFIX_PRODUCT("PREFIX_PRODUCT"),
    SUFFIX_PRODUCT("SUFFIX_PRODUCT"),
}