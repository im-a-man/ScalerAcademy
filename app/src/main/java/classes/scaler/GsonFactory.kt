package classes.scaler

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonFactory {
    /** Method-1
    Creating a singleton Gson object using Kotlin.
    It ensures that the Gson instance is lazily initialized in a thread-safe manner
     * */
    private var gson: Gson? = null
    private fun getGson() = synchronized(this) {
        if (gson == null)
            gson = Gson()
        return@synchronized gson
    }

    fun Any?.toJson() = getGson()?.toJson(this)
}

object GsonFactory1 {
    /** Method-2
    Kotlin provides a concise way to create a
    lazy-initialized singleton using the 'by lazy' delegation and it ensures thread safety by default.
     * */
    private val gsonBuilder: GsonBuilder = GsonBuilder()
    private val gson: Gson by lazy { gsonBuilder.create() }

    fun configureGson(configure: GsonBuilder.() -> Unit) {
        gsonBuilder.configure()
    }

    fun Any?.toJson() = gson.toJson(this)
}

/**
 * object GsonFactory {
 *     private val gson: Gson = Gson()
 *     fun Any?.toJson() = gson.toJson(this)
 * }
 * This is also safe because Kotlin objects are initialized in a thread-safe manner,
 * and there is no need for explicit synchronization.
* */