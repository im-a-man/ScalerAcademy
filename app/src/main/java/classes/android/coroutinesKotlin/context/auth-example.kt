package classes.android.coroutinesKotlin.context

import classes.android.coroutinesKotlin.run.runBlocking
import kotlin.coroutines.*

suspend fun doSomething() {
    val currentUser = coroutineContext[AuthUser]?.name ?: throw SecurityException("unauthorized")
    println("Current user is $currentUser")
}

fun main(args: Array<String>) {
    runBlocking(AuthUser("admin")) {
        doSomething()
    }
}
