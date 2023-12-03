package classes.android.retroFitClient

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

fun main() {
    val retrofitClient = classes.android.retroFitClient.RetrofitClient(
        "https://api.publicapis.org",
        classes.android.retroFitClient.ApiMethods::class.java
    )
    val disposable = retrofitClient.getService().getApi()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map { it.toString() }
        .subscribe(
            { onNext -> println(onNext) },
            { onError -> println(onError) },
            { println("Completed") })
    disposable.dispose()
}