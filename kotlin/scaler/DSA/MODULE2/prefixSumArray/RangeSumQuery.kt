package classes.scaler.DSA.MODULE2.prefixSumArray

/*

Problem Description
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

* */
fun main() {
    println(rangeSum(intArrayOf(1, 2, 3, 4, 5), arrayOf(intArrayOf(0, 3), intArrayOf(1, 2))).toList())
}

fun rangeSum(A: IntArray, B: Array<IntArray>): IntArray {
    for (i in 1 until A.size)
        A[i] = A[i - 1] + A[i] //The prefix sum formula
    val sum = IntArray(B.size)
    for (i in B.indices) {
        val l = B[i][0]
        val r = B[i][1]
        if (l>=0 && r<=A.size-1) {
            if (l == 0) sum.set(i,A[r])
            else sum.set(i,A[r] - A[l - 1])
        }
    }
    return sum
}


/*

Problem Constraints
1 <= N, M <= 10 ki pow 5
1 <= A[i] <= 10 ki pow 9
0 <= L <= R < N

* */
fun rangeSum1(A: IntArray, B: Array<IntArray>): LongArray {
    if(A.size<1 || B.size>100000){//1 <= N, M <= 10 ki pow 5
        return LongArray(B.size)
    }

    for (i in 1 until A.size)
        A[i] = A[i - 1] + A[i] //The prefix sum formula
    val sum = LongArray(B.size)
    for (i in B.indices) {
        val l = B[i][0]
        val r = B[i][1]
        if (l>=0 && r<=A.size-1) {//0 <= L <= R < N
            if (l == 0) sum.set(i,A[r].toLong())
            else sum.set(i,A[r] - A[l - 1].toLong())
        }
    }
    return sum
}