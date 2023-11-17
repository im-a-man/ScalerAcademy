package classes.scaler.DSA.MODULE2.prefixSumArray

//Problem Description
//Given an array A of N integers. Construct prefix sum of the array in the given array itself.

fun main() {
    val A = intArrayOf(1,2,3,4,5,6,7,8,9,10)
    for (i in 1 until A.size)
        A[i] = A[i - 1] + A[i]
    println(A.joinToString())
}