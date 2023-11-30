package classes.scaler.DSA.MODULE4.arraysTwoDimensional


/**
Problem Description
Given an array of integers A and an integer B, find and return
the minimum number of swaps required to bring all the numbers less than or equal to B together.
Note: It is possible to swap any two elements, not necessarily consecutive.

Problem Constraints
1 <= length of the array <= 100000
-109 <= A[i], B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the minimum number of swaps.

Example Input
Input 1:
A = [1, 12, 10, 3, 14, 10, 5]
B = 8
Input 2:
A = [5, 17, 100, 11]
B = 20

Example Output
Output 1:
2
Output 2:
1

Example Explanation
Explanation 1:
A = [1, 12, 10, 3, 14, 10, 5]
After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
Now, all elements less than or equal to 8 are together.

Explanation 2:
A = [5, 17, 100, 11]
After swapping 100 and 11, A => [5, 17, 11, 100].
Now, all elements less than or equal to 20 are together.
 * */

fun main() {
    println(minimumSwaps(intArrayOf(1, 12, 10, 3, 14, 10, 5), 8))
}

fun minimumSwaps(A: IntArray, B: Int): Int {
    var count = 0 //count of no. less than B or window size
    for (i in A.indices) {
        if (A[i] <= B) {
            count++
        }
    }
    var bad_nos = 0 //count of bad no.(greater than) B for a given window
    for (i in 0 until count) {
        if (A[i] > B) {
            bad_nos++
        }
    }
    var si = 1
    var ei = count
    var ans = bad_nos
    while (ei < A.size) {
        if (A[si - 1] > B) {
            bad_nos--
        }
        if (A[ei] > B) {
            bad_nos++
        }
        ans = minOf(bad_nos, ans)
        si++
        ei++
    }
    return ans
}

fun minimumSwaps(A: ArrayList<Int>, B: Int): Int {
    val n = A.size
    var goodValues = 0
    // Count good values in the entire array
    for (i in 0 until n) {
        if (A[i] <= B) {
            goodValues++
        }
    }
    var badValues = 0
    //Count bad values in the current window(Window size is the goodValues size) in the given array
    for (i in 0 until goodValues) {
        if (A[i] > B) {
            badValues++
        }
    }
    var i = 0 //Start index of the window
    var j = goodValues // End index of the window (Window size)
    var minSwaps = badValues // Initialise minSwaps with the badValues
    while (j < n) { //Start iterating taking the first window to the end of array
        if (A[i] > B) { //Decrement badValues if found in the begining of the window
            badValues--
        }
        if (A[j] > B) { //Increment badValues if found at the end of the window
            badValues++
        }
        i++
        j++
        minSwaps = minOf(
            badValues,
            minSwaps
        ) //Take the minimum of badValues and minimum swaps required and thats the answer.
    }
    return minSwaps
}