package classes.scaler.interviewPreparation.codingProblems

fun main() {
    //https://www.youtube.com/watch?v=gREVHiZjXeQ

    //Output the array such that,
    //Each element is product of all elements in the array except the self index's element.
    //Without using division method
    //Input=> (1,2,3,4)

    //prefix=> (1, 2, 6, 24)
    //Suffix=> (24,24,12, 4)

    //Output=> (24, 12, 8, 6)

    println(arrayProductExceptSelf(intArrayOf(1, 2, 3, 4)).joinToString())
    println(arrayProductExceptSelfOptimisedSpaceComplexity(intArrayOf(1, 2, 3, 4)).joinToString())
}

fun arrayProductExceptSelf(array: IntArray): IntArray {
    val N = array.size
    val result = IntArray(N)
    val prefixProduct = IntArray(N)
    val suffixProduct = IntArray(N)

    prefixProduct[0] = array[0]
    for (i in 1 until N)
        prefixProduct[i] = prefixProduct[i - 1] * array[i]

    suffixProduct[N - 1] = array[N - 1]
    for (i in N - 2 downTo 0)
        suffixProduct[i] = suffixProduct[i + 1] * array[i]

    result[0] = suffixProduct[1]
    result[N - 1] = prefixProduct[N - 2]

    for (i in 1 until (N - 1)) {
        result[i] = prefixProduct[i - 1] * suffixProduct[i + 1]
    }
    return result
    //T.C=> O(N)
    //S.C=> O(N)
}

fun arrayProductExceptSelfOptimisedSpaceComplexity(array: IntArray): IntArray {
    //IN-PLACE Algorithm
    val N = array.size
    val prefixProduct = IntArray(N)//left prefixProducts
    var rightProduct = 1

    prefixProduct[0] = array[0]
    for (i in 1 until N)
        prefixProduct[i] = prefixProduct[i - 1] * array[i]

    for (i in (N - 1) downTo 0) {
        if (i == 0)
            prefixProduct[i] = rightProduct
        else
            prefixProduct[i] = prefixProduct[i - 1] * rightProduct
        rightProduct *= array[i]
    }
    //T.C=> O(N)
    //S.C=> O(1), because space complexity is not counted for output array
    return prefixProduct
}