package classes.scaler.DSA.MODULE2.prefixSumArray

//Special indexes => Special indexes are those after removing which
//sum of all even indexes elements is equal to sum of all odd indexes elements.

/*
Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices
such that removing an element from these indices makes the sum
of even-indexed and odd-indexed array elements equal.

Input Format
First argument contains an array A of integers of size N.


Output Format
Return the count of array indices such that removing an element from these
indices makes the sum of even-indexed and odd-indexed array elements equal.

* */

fun main() {
    println(solve(intArrayOf(1, 1, 1)))
}

fun solve(A: IntArray): Int {
    val prefixEven = arrayListOf<Int>()
    val prefixOdd = arrayListOf<Int>()
    prefixEven.add(A[0])
    prefixOdd.add(0)
    for (i in 1..<A.size)
        if (i % 2 == 1)
            prefixEven.add(prefixEven[i - 1])
        else
            prefixEven.add(prefixEven[i - 1] + A[i])
    for (i in 1..<A.size)
        if (i % 2 == 0)
            prefixOdd.add(prefixOdd[i - 1])
        else
            prefixOdd.add(prefixOdd[i - 1] + A[i])

    var count = 0
    for (i in A.indices) {
        //Delete ith index
        var sumOfEven = prefixOdd[A.size - 1] - prefixOdd[i]
        if (i!=0){
            sumOfEven+=prefixEven[i-1]
        }
        var sumOfOdd = prefixEven[A.size - 1] - prefixEven[i]
        if (i!=0){
            sumOfOdd+=prefixOdd[i-1]
        }
        if (sumOfEven == sumOfOdd)
            count++
    }
    return count
}