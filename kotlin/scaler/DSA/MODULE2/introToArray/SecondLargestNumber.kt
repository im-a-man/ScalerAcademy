package classes.scaler.DSA.MODULE2.introToArray

import java.util.PriorityQueue

fun main() {
    val arr = intArrayOf(3, 7, 1, 9, 5, 4)
    val (firstMax, secondMax) = findSecondLargestRecursive(arr, 0, arr.size - 1)
    if (secondMax != null) {
        println("The second largest number is: $secondMax")
    } else {
        println("There is no second largest number in the array.")
    }

    //If no second largest is found then return -1
    println(findSecondLargest(arr))
}

fun findSecondLargest(a: IntArray): Int {
    var first_largest = 0
    var second_largest = -1
    for (i in a.indices) {
        if (a[i] > a[first_largest]) {
            second_largest = first_largest
            first_largest = i
        } else if (a[i] < a[first_largest]) {
            if (second_largest == -1 || a[second_largest] < a[i])
                second_largest = i
        }
    }
    return if (second_largest == -1) -1 else a[second_largest]
}

fun findSecondLargestRecursive(arr: IntArray, left: Int, right: Int): Pair<Int, Int?> {
    if (left == right) {
        return Pair(arr[left], null)
    } else if (right - left == 1) {
        return if (arr[left] > arr[right]) {
            Pair(arr[left], arr[right])
        } else {
            Pair(arr[right], arr[left])
        }
    } else {
        val mid = (left + right) / 2
        val (leftMax, leftSecondMax) = findSecondLargestRecursive(arr, left, mid)
        val (rightMax, rightSecondMax) = findSecondLargestRecursive(arr, mid + 1, right)

        val firstMax: Int
        val secondMax: Int?

        if (leftMax > rightMax) {
            firstMax = leftMax
            secondMax =
                if (leftSecondMax != null && leftSecondMax > rightMax) leftSecondMax else rightMax
        } else {
            firstMax = rightMax
            secondMax =
                if (rightSecondMax != null && rightSecondMax > leftMax) rightSecondMax else leftMax
        }

        return Pair(firstMax, secondMax)
    }
}