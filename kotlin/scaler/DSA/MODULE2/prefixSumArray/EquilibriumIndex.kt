package classes.scaler.DSA.MODULE2.prefixSumArray

import classes.scaler.GsonFactory.toJson

/*
Problem Description
You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

Note:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.

Input Format
First arugment is an array A .


Output Format
Return the equilibrium index of the given array. If no such index is found then return -1.

* */

fun main() {
    val (index, value) = findEquilibriumIndices(intArrayOf(-7, 1, 5, 2, -4, 3, 0))
    println("Equilibrium index is $index and value is $value")
}

fun findEquilibriumIndices(A: IntArray): Pair<Int, Int> {
    var leftSum = 0
    var rightSum = A.sum()// Calculate the initial sum of all elements
    for (i in A.indices) {
        rightSum -= A[i]// Update rightSum by subtracting the current element
        if (leftSum == rightSum)
            return Pair(i, A[i])
        leftSum += A[i]// Update leftSum for the next iteration
    }
    return Pair(Int.MIN_VALUE, Int.MIN_VALUE)
}