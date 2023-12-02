package classes.scaler.rxJava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable

fun main() {
    exDoOnSubscribe()
    exDoOnNext()
    exDoOnComplete()

    //----------------------------------------------------------------
    exDoFinally()
    exDoOnDispose()
}

/**
 * doOnSubscribe will get the disposable as soon as we subscribe the specific observable
 */
private fun exDoOnSubscribe() {
    Observable.just(1, 2, 3, 4, 5)
        .doOnSubscribe { disposable -> println("doOnSubscribe: Subscribed") }
        .subscribe(System.out::println)
}

/**
 * doOnNext will get the item just before it reaches to the downstream of onNext
 */
private fun exDoOnNext() {
    Observable.just(1, 2, 3, 4, 5)
        .doOnNext { item ->
            var item = item
            println("doOnNext: " + ++item)
        }
        .subscribe(System.out::println)
}

/**
 * doOnComplete will get void just before it reaches to the downstream of onComplete
 */
private fun exDoOnComplete() {
    Observable.just(1, 2, 3, 4, 5)
        .doOnComplete { println("doOnComplete: Completed") }
        .subscribe(System.out::println, System.out::print) { println("Completed") }
}

/**
 * doFinally works after the observable is done or onComplete
 */
private fun exDoFinally() {
    Observable.just(1, 2, 3, 4, 5)
        .doFinally { println("doFinally: Completed") }
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * doOnDispose only works if we can dispose the observable explicitly
 * before onComplete or onError
 */
private fun exDoOnDispose() {
    Observable.just(1, 2, 3, 4, 5)
        .doOnDispose { println("onDispose: Disposed") }
        .doOnSubscribe { disposable: Disposable -> disposable.dispose() }
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}