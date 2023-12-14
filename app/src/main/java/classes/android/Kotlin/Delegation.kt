package classes.android.Kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import kotlin.reflect.KProperty

class DelegateActivity : AppCompatActivity(),
    AnalyticsLogger by AnalyticsLoggerImpl(),
    DeepLinkHandler by DeepLinkHandlerImp() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Log this activity using delegation, 'by' keyword.
        //Giving the responsibility of logging to the delegated class through interfaces,
        //Without using inheritance,
        //actually in inheritance we violate the SOLID principle,
        //By put two things-responsibility in one Baseclass just for using two behaviors,
        //Because we can't inherit two classes in kotlin.
        //But using delegation we can have as many as type of behavior separately
        registerLifeCycleOwner(this)
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        //Delegating the responsibility of handling the deep links to DeepLinkHandler,
        //Instead of inheriting and overriding the deepLinkHandler method.
        handleDeepLink(intent)
    }
}

interface AnalyticsLogger {
    fun registerLifeCycleOwner(owner: LifecycleOwner)
}


class AnalyticsLoggerImpl : AnalyticsLogger, LifecycleEventObserver {
    override fun registerLifeCycleOwner(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                println("User entered into the screen")
            }

            Lifecycle.Event.ON_PAUSE -> {
                println("User leaves the screen")
            }

            else -> {}
        }
    }
}

interface DeepLinkHandler {
    fun handleDeepLink(intent: Intent?)
}

class DeepLinkHandlerImp : DeepLinkHandler {
    override fun handleDeepLink(intent: Intent?) {

    }
}

class Using_by_keyword_with_lazy {
    //Delegating the initialization to lazy
    private val logger by lazy {
        println("Lazy initialization")
        3
    }

    //Delegating the initialization to custom lazy
    private val logger1 by MyLazy {
        println("Lazy initialization")
        3
    }
}

//Property delegation
class MyLazy<out T : Any?>(private val initializer: () -> T) {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return if (value == null) {
            value = initializer()
            value!!
        } else value!!
    }
}