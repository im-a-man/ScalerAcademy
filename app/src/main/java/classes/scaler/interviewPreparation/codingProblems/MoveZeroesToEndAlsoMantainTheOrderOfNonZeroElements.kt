package classes.scaler.interviewPreparation.codingProblems

fun main() {
    //Input => intArray(0,1,0,3,12)
    //Output => intArray(1,3,12,0,0)
    //Do this in-place algorithm, means do not use extra array
    println(moveZeros(intArrayOf(0, 1, 0, 3, 12)).joinToString())
}

//https://www.youtube.com/watch?v=PNJoyRaIW7U&list=PLEJXowNB4kPwCPVjDv6KsAsThtDOCQUok&index=4
fun moveZeros(array: IntArray): IntArray {
    var left = 0
    var right = 0
    //Scroll two pointers to the right

    while (right < array.size) {
        if (array[right] == 0)
            right++
        else {
            val temp = array[right]
            array[right] = array[left]
            array[left] = temp

            right++
            left++
        }
    }
    return array
}