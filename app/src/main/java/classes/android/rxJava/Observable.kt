package classes.android.rxJava

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

fun main() {
    val list = Observable
        .just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(::print)
}