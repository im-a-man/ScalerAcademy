package classes.scaler.DSA.MODULE2.introToArray

fun countElementsWithGreaterElements(A: IntArray): Int {
    var count = 0
    for (i in A.indices) {
        for (j in A.indices) {
            if (i != j && A[j] > A[i]) {
                count++
                break
            }
        }
    }
    return count
}

fun main() {
    val A = intArrayOf(3, 1, 7, 0, 4, 2)
    val result = countElementsWithGreaterElements(A)
    println("Number of elements with at least one greater element: $result")
}
