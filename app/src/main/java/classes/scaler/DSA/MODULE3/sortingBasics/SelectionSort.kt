package classes.scaler.DSA.MODULE3.sortingBasics

import classes.GsonFactory.toJson

fun main() {
    val array = intArrayOf(3, 17, 1, 16, 2, 5)
    selectionSort(array)//T.C => Big O(N2), S.C => Big O(1)
    println(array.toJson())
}

fun selectionSort(array: IntArray) {
    var minIndex = 0
    for (i in array.indices) {
        minIndex = i

        // Find the index of the minimum element in the remaining unsorted array
        for (j in i + 1 until array.size) {
            if (array[j] < array[minIndex])
                minIndex = j
        }

        // Swap the found minimum element with the element at index i
        swap(i, minIndex, array)
    }
}

fun swap(i: Int, j: Int, array: IntArray) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}
