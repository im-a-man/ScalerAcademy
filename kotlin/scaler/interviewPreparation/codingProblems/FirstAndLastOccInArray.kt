package classes.scaler.interviewPreparation.codingProblems

fun main() {
    val (firstIndex, lastIndex) = firstAndLastOccuOfAnElementInArray(
        intArrayOf(
            2,
            4,
            1,
            1,
            2,
            1,
            1,
            4,
            1,
            5
        )
    )
    println("First index: $firstIndex, last index: $lastIndex")
}

fun firstAndLastOccuOfAnElementInArray(array: IntArray): Pair<Int, Int> {
    var (firstIndex, lastIndex) = Pair(array.size - 1, 0)
    var (l, r) = Pair(0, array.size - 1)
    val n = 1 //To be find
    while (l < r) {
        if (array[l] == n)
            firstIndex = minOf(firstIndex, l)
        if (array[r] == n)
            lastIndex = maxOf(lastIndex, r)
        l++
        r--
    }
    return Pair(firstIndex, lastIndex)
}