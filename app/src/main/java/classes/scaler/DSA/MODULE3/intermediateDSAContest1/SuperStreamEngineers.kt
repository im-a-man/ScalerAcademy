package classes.scaler.DSA.MODULE3.intermediateDSAContest1


fun main() {
    val A = intArrayOf(30, 25, 40, 35, 20, 45, 50, 55, 22, 18, 15)
    val B = 3
    val C = 30
    println(solve(A,B,C))
}

fun solve(A: IntArray, B: Int, C: Int): Int {
    var sum = 0L
    for (i in 0 until B)
        sum += A[i].toLong()
    if ((sum / B) < C.toLong())
        return 1
    var sIndex = 1
    var eIndex = B
    while (eIndex < A.size) {
        sum += A[eIndex].toLong() - A[sIndex - 1].toLong()
        if ((sum / B) < C.toLong())
            break
        sIndex++
        eIndex++
    }
    if ((sum / B) < C.toLong())
        return 1
    else
        return 0
}