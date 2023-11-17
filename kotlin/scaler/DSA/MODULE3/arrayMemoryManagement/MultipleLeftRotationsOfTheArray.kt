package classes.scaler.DSA.MODULE3.arrayMemoryManagement

import classes.scaler.DSA.MODULE2.introToArray.reversePart
import classes.scaler.GsonFactory.toJson
import com.google.gson.Gson


/*
Problem Description
Given an array of integers A and multiple values in B,
which represents the number of times array A needs to be left rotated.
Find the rotated array for each value and return the result
in the from of a matrix where ith row represents the rotated array for the ith value in B.

Problem Constraints
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000

Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format
Return the resultant matrix.

Example Input
Input 1:
    A = [1, 2, 3, 4, 5]
    B = [2, 3]
Input 2:
    A = [5, 17, 100, 11]
    B = [1]

Example Output
Output 1:
     [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]
Output 2:
    [ [17, 100, 11, 5] ]

Example Explanation
for input 1 -> B[0] = 2 which requires 2 times left rotations
1: [2, 3, 4, 5, 1]
2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation
1: [2, 3, 4, 5, 1]
2: [3, 4, 5, 1, 2]
2: [4, 5, 1, 2, 4]
* */

fun customPrintln(input: ArrayList<Int?>?) {
    println(input.toJson())
}

fun main() {
    //val list1 = solve(arrayListOf(31, 17, 21, 19, 16), arrayListOf(3)) //21, 19, 16, 31, 17
    //val list1 = solve(arrayListOf(5, 17, 100, 11), arrayListOf(1)) //[ 17 100 11 5 ]
    val list1 = solve(arrayListOf(1, 2, 3, 4, 5), arrayListOf(2, 3))
    //[3,4,5,1,2]
    //[4,5,1,2,3]
    list1?.forEach(::customPrintln)

    println(
        multipleRotationOnString(
            arrayListOf('a', 'b', 'c', 'd', 'e', 'f', 'g'),
            arrayListOf(3)
        ).toJson()
    )
}

fun solve(A: ArrayList<Int?>, B: ArrayList<Int>): ArrayList<ArrayList<Int?>?>? {
    val ans: ArrayList<ArrayList<Int?>?> = arrayListOf()
    for (i in B.indices) {
        val K = B[i] % A.size
        ans.add(ArrayList(A.subList(K, A.size) + A.subList(0, K)))
    }
    return ans
}

fun multipleRotationOnString(A: ArrayList<Char?>, B: ArrayList<Int>): ArrayList<List<Char?>> {
    val ans: ArrayList<List<Char?>> = arrayListOf()
    for (i in B.indices) {
        val K = B[i] % A.size
        ans.add(ArrayList(A.subList(K, A.size) + A.subList(0, K)))
    }
    return ans
}