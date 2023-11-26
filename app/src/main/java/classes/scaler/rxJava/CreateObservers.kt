package classes.scaler.rxJava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

fun main() {
    val observable = Observable.just(1, 2, 3, 4, 5)
    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            println(d.isDisposed)
        }

        override fun onError(e: Throwable) {
            println(e.localizedMessage)
        }

        override fun onComplete() {
            println("onComplete")
        }

        override fun onNext(t: Int) {
            println(t)
        }
    }
    observable.subscribe(observer)
}