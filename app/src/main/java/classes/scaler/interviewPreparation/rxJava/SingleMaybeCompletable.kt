package classes.scaler.interviewPreparation.rxJava

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

/**
 * These are the special type of observable with some unique qualities
 * */

fun main() {
    createSingle()
    createMayBe()
    createCompletable()
}

fun createSingle() {
    //This does not have onNext method or it does not take Observer
    Single.just("Hello world").subscribe(object : SingleObserver<String> {
        override fun onSubscribe(d: Disposable) {

        }

        override fun onError(e: Throwable) {

        }

        override fun onSuccess(t: String) {
            println(t)
        }
    })
    //Instead It takes SingleObserver and it has onSuccess method
}

fun createMayBe() {
    //And it takes MaybeObserver
    Maybe.empty<Int>().subscribe(object : MaybeObserver<Int> {
        override fun onSubscribe(d: Disposable) {

        }

        override fun onError(e: Throwable) {

        }

        override fun onComplete() {
            println("Done")
        }

        override fun onSuccess(t: Int) {
            println(t)
        }
    })
}

fun createCompletable() {
    //This takes CompletableObserver
    Completable.fromSingle(Single.just("Hello world")).subscribe(object : CompletableObserver {
        override fun onSubscribe(d: Disposable) {

        }

        override fun onComplete() {
            println("Done")
        }

        override fun onError(e: Throwable) {

        }
    })
}