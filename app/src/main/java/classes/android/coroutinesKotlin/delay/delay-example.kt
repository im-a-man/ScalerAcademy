package classes.android.coroutinesKotlin.delay

import classes.android.coroutinesKotlin.context.Swing
import classes.android.coroutinesKotlin.util.log
import future.*

fun main(args: Array<String>) {
    future(Swing) {
        log("Let's naively sleep for 1 second")
        delay(1000L)
        log("We're still in Swing EDT!")
    }
}