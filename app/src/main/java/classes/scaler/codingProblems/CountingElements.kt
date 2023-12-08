package classes.scaler.interviewPreparation.codingProblems

import classes.GsonFactory.toJson

/*
Count no of elements, only those elements whose greater by 1 element is present in array
Ex=> if x = 4,
then x + 1 = 4+1 = 5
if 5 is present in array then count element 4
* */

fun main() {
    println("Please enter array elements separated by comma =>")
    //Input=> 1,3,2,3,5,0 -> count = 3
    //Input=> 1,1,1,1,2 -> count = 4

    val input = readlnOrNull()
    val args = input?.split(",")?.map { it.toInt() }?.toIntArray() ?: intArrayOf()

    args.sort()
    println(args.toJson())
    var left = 0
    var right = 1
    var count = 0
    while (right < args.size) {
        if (args[right] == (args[left] + 1)) {
            count += (right - left)
            left = right
            right++
        } else if (args[right] == args[left]) {
            right++
        } else {
            left = right
            right++
        }
    }
    println(count)
}