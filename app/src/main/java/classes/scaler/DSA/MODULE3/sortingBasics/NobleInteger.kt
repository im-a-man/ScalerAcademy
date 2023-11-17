package classes.scaler.DSA.MODULE3.sortingBasics

/*
Problem Description
Given an integer array A, find if an integer p exists in
the array such that the number of integers greater than p
in the array equals p.

Problem Constraints
1 <= |A| <= 2*105
-108 <= A[i] <= 108

Input Format
First and only argument is an integer array A.

Output Format
Return 1 if any such integer p is present else, return -1.

Example Input
Input 1:
 A = [3, 2, 1, 3]
Input 2:
 A = [1, 1, 3, 3]

Example Output
Output 1:
 1
Output 2:
-1

Example Explanation
Explanation 1:
 For integer 2, there are 2 greater elements in the array..
Explanation 2:
 There exist no integer satisfying the required conditions.
* */

fun main() {
    //1,2,3,3
    println(solve(intArrayOf(3, 2, 1, 3)))
    println(solveIfDuplicatesExist(intArrayOf(3, 2, 1, 3)))
    println(solveByBruteforce(intArrayOf(3, 2, 1, 3)))
    println(solveByExpert(intArrayOf(7, 3, 2, 4, 9, -2, 15, 11)))
}

fun solve(A: IntArray): Int {
    val A1 = A.sortedDescending()
    var answer = 0
    for (i in A1.indices) {
        if (A1[i] == i) {
            answer += 1
        }
    }
    return answer
}

fun solveIfDuplicatesExist(A: IntArray): Int {
    val A1 = A.sortedDescending()
    var answer = 0
    var countSmaller = 0
    if (A1[0] == 0) answer=0 // because at 0 index maximum element should be after sorting descending
    for (i in 1 until A.size) {
        if (A1[i] != A1[i - 1])
            countSmaller = i //countSmaller+=i
        if (A1[i] == countSmaller)
            answer += 1
    }
    return answer
}

fun solveByBruteforce(A: IntArray): Int {
    var answer = 0
    for (i in A.indices) {
        var countGreater = 0
        for (j in A.indices) {
            if (A[j] > A[i])
                countGreater += 1
        }
        if (countGreater == A[i])
            answer += 1
    }
    return answer
}

fun solveByExpert(A: IntArray): Int {
    val arr = A.distinct().sorted()
    var answer = 0
    for (i in arr.indices) {
        if (arr[i] == (arr.size - 1 - i)) { // (N-1-i)
            answer += 1
            print(arr[i].toString()+"=>")
        }
    }
    return answer
}