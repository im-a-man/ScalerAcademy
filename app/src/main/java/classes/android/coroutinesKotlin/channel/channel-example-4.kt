package channel.example4

import classes.android.coroutinesKotlin.channel.Channel
import classes.android.coroutinesKotlin.channel.SendChannel
import classes.android.coroutinesKotlin.channel.go
import classes.android.coroutinesKotlin.channel.mainBlocking

// https://tour.golang.org/concurrency/4

suspend fun fibonacci(n: Int, c: SendChannel<Int>) {
    var x = 0
    var y = 1
    for (i in 0..n - 1) {
        c.send(x)
        val next = x + y
        x = y
        y = next
    }
    c.close()
}

fun main(args: Array<String>) = mainBlocking {
    val c = Channel<Int>(2)
    go { fibonacci(10, c) }
    for (i in c) {
        println(i)
    }
}
