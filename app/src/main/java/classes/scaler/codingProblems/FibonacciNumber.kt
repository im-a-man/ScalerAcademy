package classes.scaler.interviewPreparation.codingProblems

import classes.GsonFactory.toJson

fun fibonacciByBottomUp(n: Int): Long {
    if (n <= 1)
        return n.toLong()

    var first = 0L
    var second = 1L
    val list = ArrayList<Long>()
    list.add(first)
    list.add(second)
    for (i in 2..n) {
        val next = first + second
        first = second
        second = next
        list.add(next)
    }
    println(list.toJson())

    return second
}

fun fibonacciByRecursive(n: Int): Long {
    return if (n <= 1) {
        n.toLong()
    } else {
        fibonacciByRecursive(n - 1) + fibonacciByRecursive(n - 2)
    }
}

fun fibonacciByMemoizationApproach(n: Int, memo: HashMap<Int, Long>): Long {
    if (n <= 1)
        return n.toLong()
    if (memo.containsKey(n))
        return (memo[n] ?: 0L)

    val fibValue =
        fibonacciByMemoizationApproach(n - 1, memo) + fibonacciByMemoizationApproach(n - 2, memo)
    memo[n] = fibValue
    return fibValue
}

fun main() {
    val n = 10 // Change this value to calculate Fibonacci for a different number
    val result = fibonacciByBottomUp(n) //Big-O(N Square)
    println("Fibonacci of $n is: $result")

    val result1 = fibonacciByRecursive(n)//Big-O(N Square)
    println("Fibonacci of $n is: $result1")

    val memo = HashMap<Int, Long>()
    val result2 = fibonacciByMemoizationApproach(n, memo)//Big-O(N)
    println("Fibonacci of $n is: $result2")
}