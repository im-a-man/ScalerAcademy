package classes.scaler.interviewPreparation.codingProblems.patterns

fun main() {
    print(5)
}

fun print(n: Int) {
    printSandTimer(n)
    println("--------------------------------")
    printSandTimer1(n)
    println("--------------------------------")
    printSandTimer2(n)
}

fun printSandTimer(height: Int) {
    for (i in 0 until (2 * height) - 1) {
        val spaces = if (i < height) i else ((2 * height) - i - 2)
        val asterisks = ((2 * height) - (2 * spaces) - 1)
        repeat(spaces) {
            print(" ")
        }
        repeat(asterisks) {
            print("*")
        }
        println()
    }
}

fun printSandTimer1(height: Int) {
    for (i in 0 until (2 * height)) {
        val spaces = if (i < height) i else ((2 * height) - i - 1)
        val asterisks = ((2 * height) - (2 * spaces))
        repeat(spaces) {
            print(" ")
        }
        repeat(asterisks) {
            print("*")
        }
        println()
    }
}

fun printSandTimer2(height:Int) {
    val n = height
    var i: Int = 1
    var j: Int
    var k: Int
    while (i <= n) {
        j = 1
        while (j < i) {
            print(' ')
            j++
        }
        k = i
        while (k <= n) {
            print("* ")
            k++
        }
        println()
        i++
    }
    i = n - 1
    while (i >= 1) {
        j = 1
        while (j < i) {
            print(' ')
            j++
        }
        k = i
        while (k <= n) {
            print("* ")
            k++
        }
        println()
        i--
    }
}