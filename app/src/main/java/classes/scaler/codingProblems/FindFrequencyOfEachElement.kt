package classes.scaler.codingProblems

fun findFrequencyOfEachElement(arr: IntArray): Map<Int, Int> {
    val frequencyMap = mutableMapOf<Int, Int>()

    var left = 0
    var right = 0

    while (right < arr.size) {
        if (arr[left] == arr[right]) {
            // Expand the range of the same element
            right++
        } else {
            // Count the frequency of the current element
            frequencyMap[arr[left]] = right - left

            // Move the left pointer to the next unique element
            left = right
        }
    }

    // Handle the last element
    frequencyMap[arr[left]] = right - left

    return frequencyMap
}

fun main() {
    //For sorted arrays
    val sortedArray = intArrayOf(1, 2, 2, 2, 3, 4, 4, 4, 5, 6, 6, 7)

    val frequencyMap = findFrequencyOfEachElement(sortedArray)

    println("Frequency of each element:")
    frequencyMap.forEach { (element, frequency) ->
        println("$element: $frequency")
    }
}