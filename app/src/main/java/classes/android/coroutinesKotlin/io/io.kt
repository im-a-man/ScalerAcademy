package io

import android.os.Build
import androidx.annotation.RequiresApi
import java.nio.*
import java.nio.channels.*
import kotlin.coroutines.*

@RequiresApi(Build.VERSION_CODES.O)
suspend fun AsynchronousFileChannel.aRead(buf: ByteBuffer): Int =
    suspendCoroutine { cont ->
        read(buf, 0L, Unit, object : CompletionHandler<Int, Unit> {
            override fun completed(bytesRead: Int, attachment: Unit) {
                cont.resume(bytesRead)
            }

            override fun failed(exception: Throwable, attachment: Unit) {
                cont.resumeWithException(exception)
            }
        })
    }
