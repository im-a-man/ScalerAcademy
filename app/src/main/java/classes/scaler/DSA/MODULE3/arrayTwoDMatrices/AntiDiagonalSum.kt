package classes.scaler.DSA.MODULE3.arrayTwoDMatrices

fun main() {
    println(
        antiDiagonalSum(
            arrayOf(
                intArrayOf(1, -2, -3),
                intArrayOf(-4, 5, -6),
                intArrayOf(-7, -8, 9)
            )
        )
    )
}

fun antiDiagonalSum(A: Array<IntArray>): Int {
    var i = 0
    var j = A.size-1
    var sum = 0
    while (i < A.size) {
        sum += A[i][j]
        i++
        j--
    }
    return sum
}