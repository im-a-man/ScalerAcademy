package classes.scaler.DSA.MODULE3.sortingBasics

import classes.scaler.GsonFactory.toJson

fun main() {
    val array = intArrayOf(3, 17, 1, 16, 2, 5)
    insertionSort(array)//T.C => Big O(N2), S.C => Big O(1)
    println(array.toJson())
}

/*
* I've used a different style for the insertion sort
* algorithm where the inner loop iterates in a descending order.
* */
fun insertionSort(array: IntArray) {
    for (i in 1 until array.size) {
        for (j in i - 1 downTo 0) {
            if (array[j] > array[j + 1])
                swap(j, j + 1, array)
            else
                break
        }
    }
}