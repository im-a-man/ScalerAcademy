package classes.scaler.DSA.MODULE3

/**
Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
Find and return the length of the longest consecutive 1’s that can be achieved.

Input Format
The only argument given is string A.

Output Format
Return the length of the longest consecutive 1’s that can be achieved.

Constraints
1 <= length of string <= 1000000
A contains only characters 0 and 1.

For Example
Input 1:
A = "111000"
Output 1:
3

Input 2:
A = "111011101"
Output 2:
7
 * */

fun main() {
    println(lengthOfLongestConsecutiveOnes("111000"))
    println(lengthOfLongestConsecutiveOnes("111011101"))
}

fun lengthOfLongestConsecutiveOnes(arr: String): Int {
    val array = arr.toCharArray()

    var answer = 0
    var totalOnce = 0
    for (i in array.indices)
        if (array[i] == '1') totalOnce += 1
    if (totalOnce == 0) return 0
    if (totalOnce == array.size) return array.size

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
            if ((left + right) < totalOnce)
                answer = maxOf(answer, left + right + 1)
            else
                answer = maxOf(answer, left + right)
        }
    }
    return answer
}