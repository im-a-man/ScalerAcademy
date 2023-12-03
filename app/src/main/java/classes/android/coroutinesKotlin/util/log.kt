package classes.android.coroutinesKotlin.util

import android.os.Build
import java.time.*

fun log(msg: String) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    println("${Instant.now()} [${Thread.currentThread().name}] $msg")
} else {
    TODO("VERSION.SDK_INT < O")
}