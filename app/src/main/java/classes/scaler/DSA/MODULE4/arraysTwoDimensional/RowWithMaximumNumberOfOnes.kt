package classes.scaler.DSA.MODULE4.arraysTwoDimensional

/**
Problem Description
Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.

NOTE:
If two rows have the maximum number of 1 then return the row which has a lower index.
Rows are numbered from top to bottom and columns are numbered from left to right.
Assume 0-based indexing.
Assume each row to be sorted by values.
Expected time complexity is O(rows + columns).

Problem Constraints
1 <= N <= 1000
0 <= A[i] <= 1

Input Format
The only argument given is the integer matrix A.

Output Format
Return the row with the maximum number of 1.

Example Input
Input 1:
A = [   [0, 1, 1]
[0, 0, 1]
[0, 1, 1]   ]
Input 2:
A = [   [0, 0, 0, 0]
[0, 0, 0, 1]
[0, 0, 1, 1]
[0, 1, 1, 1]    ]

Example Output
Output 1:
0
Output 2:
3

Example Explanation
Explanation 1:
Row 0 has maximum number of 1s.
Explanation 2:
Row 3 has maximum number of 1s.
 * */

fun main() {
    println(
        solve(
            arrayOf(
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1),
                intArrayOf(0, 0, 1, 1),
                intArrayOf(0, 1, 1, 1)
            )
        )
    )
}

fun solve(A: Array<IntArray>): Int {
    var i = 0
    var j = A.size - 1
    var row = 0
    while (i in A.indices && j in A.indices) {
        if (A[i][j] == 1) {
            row = i
            j--//Move Left if found 1
        } else
            i++//Move down if found 0
    }
    return row
}