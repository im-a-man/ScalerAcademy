package classes.android.coroutinesKotlin.io

import android.os.Build
import androidx.annotation.RequiresApi
import classes.android.coroutinesKotlin.context.Swing
import classes.android.coroutinesKotlin.run.launch
import classes.android.coroutinesKotlin.util.log
import io.aRead
import run.*
import util.*
import java.nio.*
import java.nio.channels.*
import java.nio.file.*

@RequiresApi(Build.VERSION_CODES.O)
fun main(args: Array<String>) {
    launch(Swing) {
        val fileName = "examples/io/io.kt"
        log("Asynchronously loading file \"$fileName\" ...")
        val channel = AsynchronousFileChannel.open(Paths.get(fileName))
        try {
            val buf = ByteBuffer.allocate(4096)
            val bytesRead = channel.aRead(buf)
            log("Read $bytesRead bytes starting with \"${String(buf.array().copyOf(10))}\"")
        } finally {
            channel.close()
        }
    }
}
