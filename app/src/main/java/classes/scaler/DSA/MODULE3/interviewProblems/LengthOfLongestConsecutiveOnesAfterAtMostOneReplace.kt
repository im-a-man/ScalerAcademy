package classes.scaler.DSA.MODULE3.interviewProblems

/**
 * Given a binary string A. It is allowed to do at most one replacement between any 0 and 1.
 * Find and return the length of the longest consecutive 1’s that can be achieved.
 *
 * Input Format
 * The only argument given is string A.
 *
 * Output Format
 * Return the length of the longest consecutive 1’s that can be achieved after the replacement.
* */
fun main() {
    println(lengthOfLongestConsecutiveOnesAfterReplace("111000"))
    println(lengthOfLongestConsecutiveOnesAfterReplace("111011101"))
}

fun lengthOfLongestConsecutiveOnesAfterReplace(arr: String): Int {
    val array = arr.toCharArray()

    var answer = 1//This is the max possible consecutive ones

    var countOfZeros = 0
    for (i in array.indices)
        if (array[i] == '0') countOfZeros += 1
    if (countOfZeros == 0) return array.size
    if (countOfZeros == array.size) return 1

    for (i in array.indices) {
        if (array[i] == '0') {
            //Find the count of consecutive once on left hand side
            var left = 0
            for (j in i - 1 downTo 0)
                if (array[j] == '1') left += 1
                else break

            //Find the count of consecutive once on right hand side
            var right = 0
            for (j in i + 1 until array.size)
                if (array[j] == '1') right += 1
                else break

            answer = maxOf(answer, left + right + 1)
        }
    }
    return answer
}