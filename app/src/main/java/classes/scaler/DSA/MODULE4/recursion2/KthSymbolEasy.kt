package classes.scaler.DSA.MODULE4.recursion2

/**
Problem Description
On the first row, we write a 0. Now in every subsequent row,
we look at the previous row and replace each occurrence of 0 with 01,
and each occurrence of 1 with 10.
Given row number A and index B, return the Bth indexed symbol in row A.
(The values of B are 0-indexed.).

Problem Constraints
1 <= A <= 20
0 <= B < 2A - 1

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return an integer denoting the Bth indexed symbol in row A.

Example Input
Input 1:
A = 3
B = 0
Input 2:
A = 4
B = 4

Example Output
Output 1:
0
Output 2:
1

Example Explanation
Explanation 1:
Row 1: 0
Row 2: 01
Row 3: 0110
Explanation 2:
Row 1: 0
Row 2: 01
Row 3: 0110
Row 4: 01101001
 * */

fun main() {
    println(kthSymbol(3, 0))
}

fun kthSymbol(A: Int, B: Int): Int {
    if (B == 0 || B == 1) return B
    val indices = 1 shl A - 1 //contains count of elements in row A which will be 2^(A-1)
    return if (B < indices / 2) //if B is in the first half, it will be the same symbol on the same index of prev row
        kthSymbol(
            A - 1,
            B
        ) else  //if B is in the second half, it will be the opposite symbol on the prev row at B - indices/2 index
        1 - kthSymbol(A - 1, B - indices / 2)
}

/*



EXAMPLE:

Let's expand till row 5, for example:

1.  0

2.  0 1

3.  0 1 1 0

4.  0 1 1 0 1 0 0 1

5.  0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0





OBSERVATION:

Here we observe that-

1. every row is double the count of elements in prev row

2. the first half elements of any row are identical to those of previous row

3. the second half of elements of any row are inverse of the first half of the elements





APPROACH:

1. We will see the Base condition would be 0 if B == 0, and 1 if B == 1

2. from observation 2 (above), if B is present in 1st half of the elements, we will recursively call the function to check the

    prev row (A-1) for the same index B

3. from the observation 3 (above), if B is present in the 2nd half of the elements, we will take inverse (i.e. 1 - symbol) of

    the element at prev row at index B - half of indices.



*/