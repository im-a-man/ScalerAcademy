package classes.scaler.DSA.MODULE2.introToArray

fun main() {
//    Given an integer array A of size N. In one second, you can increase the value of one element by 1.
//    Find the minimum time in seconds to make all elements of the array equal.
    val arr = intArrayOf(2, 4, 1, 3, 2)
    val max = arr.max()
    var count = 0
    for (element in arr) {
        count += (max - element)
    }
    println(count)
}