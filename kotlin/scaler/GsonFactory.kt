package classes.scaler

import com.google.gson.Gson

object GsonFactory {
    private var gson: Gson? = null
    private fun getGson() = synchronized(this) {
        if (gson == null)
            gson = Gson()
        return@synchronized gson
    }

    fun Any?.toJson() = getGson()?.toJson(this)
}