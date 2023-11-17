package classes.scaler.DSA.MODULE2.introToArray

//Good example
fun findMinAndMax(arr: IntArray): Pair<Int, Int> {
    if (arr.isEmpty()) {
        throw IllegalArgumentException("Array is empty")
    }

    var min = arr[0]
    var max = arr[0]
    var i = 1

    // If the array has an odd number of elements, initialize min and max with the first element.
    if (arr.size % 2 != 0) {
        i = 2
        if (arr[1] < min) {
            min = arr[1]
        } else {
            max = arr[1]
        }
    }

    while (i < arr.size - 1) {
        if (arr[i] < arr[i + 1]) {
            if (arr[i] < min) min = arr[i]
            if (arr[i + 1] > max) max = arr[i + 1]
        } else {
            if (arr[i + 1] < min) min = arr[i + 1]
            if (arr[i] > max) max = arr[i]
        }
        i += 2
    }
    return Pair(min, max)
}

//Best example
fun findMinAndMax1(array: IntArray): Pair<Int, Int> {
    if (array.isEmpty()) {
        throw IllegalArgumentException("Array is empty")
    }

    var min = array[0]
    var max = array[0]

    // Iterate through the array in pairs
    for (i in 0 until array.size - 1 step 2) {
        val a = array[i]
        val b = array[i + 1]

        if (a < b) {
            if (a < min) min = a
            if (b > max) max = b
        } else {
            if (b < min) min = b
            if (a > max) max = a
        }
    }

    // If the array size is odd, compare the last element with min and max
    if (array.size % 2 == 1) {
        val lastElement = array[array.size - 1]
        if (lastElement < min) min = lastElement
        else if (lastElement > max) max = lastElement
    }

    return Pair(min, max)
}

//Good example
fun findMinAndMax2(array: IntArray): Pair<Int, Int> {
    if (array.isEmpty()) {
        throw IllegalArgumentException("Array is empty")
    }

    var min = array[0]
    var max = array[0]

    for (element in array) {
        if (element < min) {
            min = element
        }
        if (element > max) {
            max = element
        }
    }

    return Pair(min, max)
}

//Best
fun findMinAndMaxWithRecursion(arr: IntArray, start: Int, end: Int): Pair<Int, Int> {
    if (start == end) {
        return Pair(arr[start], arr[start]) // Base case: Array with one element
    }

    if (end - start == 1) { // Base case: Array with two elements
        return if (arr[start] < arr[end])
            Pair(arr[start], arr[end])
        else
            Pair(arr[end], arr[start])
    }

    val mid = (start + end) / 2
    val leftResult = findMinAndMaxWithRecursion(arr, start, mid)
    val rightResult = findMinAndMaxWithRecursion(arr, mid + 1, end)

    val min = if (leftResult.first < rightResult.first) leftResult.first else rightResult.first
    val max = if (leftResult.second > rightResult.second) leftResult.second else rightResult.second

    return Pair(min, max)
}

fun main() {
    val arr = intArrayOf(5, 12, 8, 25, 47, 15, 2, 41)
//    val (min, max) = findMinAndMax(arr)
    val (min, max) = findMinAndMaxWithRecursion(arr, 0, arr.size - 1)
    println("Minimum element: $min")
    println("Maximum element: $max")
    println("Maximum element: ${min+max}")
}