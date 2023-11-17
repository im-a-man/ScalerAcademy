package classes.scaler.DSA.MODULE2.introToArray

fun main() {
    val array = intArrayOf(31, 17, 21, 19, 16)//21, 19, 16, 31, 17
    val size = array.size
    var noOfRotations = 3
    noOfRotations %= size
    reversePart(array,0,size-1)
    reversePart(array,0,noOfRotations-1)
    reversePart(array,noOfRotations,size-1)
    println(array.joinToString())
}

fun reversePart(intArray: IntArray, start: Int, end: Int) {
    var l = start
    var r = end
    if (l >= 0 && r <= intArray.size - 1) {
        while (l < r) {
            val temp = intArray[l]
            intArray[l] = intArray[r]
            intArray[r] = temp
            l++
            r--
        }
    }
}