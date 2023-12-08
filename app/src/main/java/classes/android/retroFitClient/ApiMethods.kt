package classes.android.retroFitClient

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiMethods {
    @GET("/entries")
    fun getApi(): Observable<Any>
}