package classes.android.coroutinesKotlin.context

import java.util.Timer
import javax.swing.*
import kotlin.coroutines.*

suspend fun Swing.delay(millis: Int): Unit = suspendCoroutine { cont ->
    /*Timer(millis) { cont.resume(Unit) }.apply {
        isRepeats = false
        start()
    }*/
}
