package classes.scaler.DSA.MODULE3.intermediateDSAContest1

import classes.GsonFactory.toJson


fun main() {
    val A = intArrayOf(2, 7, 14, 5, 7)
    val B = arrayOf(intArrayOf(0, 2), intArrayOf(2, 4))//[[0, 2], [2, 4]]
    //Output = [2, 2]
    println(solve(A,B).toJson())
}

fun solve(A: IntArray, B: Array<IntArray>): IntArray {
    val ans = IntArray(B.size)
    for (i in B.indices) {
        var count = 0
        var left = B[i][0]
        while (left <= B[i][1]) {
            if (A[left] % 7 == 0)
                count += 1
            left++
        }
        ans[i] = count
    }
    return ans
}