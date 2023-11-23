package classes.scaler.interviewPreparation.rxJava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.ResourceObserver
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit


fun main() {
    handleDisposable()
    handleDisposableInObserver()
    handleDisposableOutsideObserver()
    compositeDisposable()
}

/**
 * Saves the returned disposable from the subscribe(),
 * and dispose it after 3000 milliseconds and pause the
 * thread for 3000 milliseconds more to check whether it emits or not
 */
private fun handleDisposable() {
    val observable: Observable<Long> = Observable.interval(1, TimeUnit.SECONDS)
    val disposable: Disposable = observable.subscribe(System.out::println)
    pause(3000)
    disposable.dispose()
    pause(3000)
}

/**
 * When we pass an Observer to the subscribe() method, it returns void.
 * So we need to get the Disposable from the overridden method onSubscribe,
 * so we can deal with it anywhere and any point in time
 */
private fun handleDisposableInObserver() {
    val observable: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    val observer: Observer<Int> = object : Observer<Int> {
        var disposable: Disposable? = null
        override fun onSubscribe(d: Disposable) {
            disposable = d
        }

        override fun onNext(integer: Int) {
            if (integer == 3) {
                disposable!!.dispose()
            }
            println(integer)
        }

        override fun onError(e: Throwable) {}
        override fun onComplete() {}
    }
    observable.subscribe(observer)
}

/**
 * Used ResourceObserver here, to the disposable out of the subscribe
 * Instead of subscribe(), subscribeWith() has been used here
 * Which returns the Observer that we pass in
 * As ResourceObserver implements Disposable,
 * so we can deal with it like it is a Disposable
 */
private fun handleDisposableOutsideObserver() {
    val observable: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    val observer: ResourceObserver<Int> = object : ResourceObserver<Int>() {
        override fun onNext(integer: Int) {
            println(integer)
        }

        override fun onError(e: Throwable) {}
        override fun onComplete() {}
    }
    val d: Disposable = observable.subscribeWith(observer)
    d.dispose()
}

/**
 * Used CompositeDisposable and used it's add method
 * to add Disposables to the set of Disposables
 * by calling the dispose on CompositeDisposable instead of disposing each and everyone
 * We can even use the delete method to remove any disposable from the set of CompositeDisposable
 */
private fun compositeDisposable() {
    val compositeDisposable = CompositeDisposable()
    val observable: Observable<Long> = Observable.interval(1, TimeUnit.SECONDS)
    val disposable1: Disposable = observable.subscribe { item ->
        println(
            "Observer 1: $item"
        )
    }
    val disposable2: Disposable = observable.subscribe { item ->
        println(
            "Observer 2: $item"
        )
    }
    compositeDisposable.addAll(disposable1, disposable2)
    pause(3000)
    compositeDisposable.delete(disposable1)
    compositeDisposable.dispose()
    pause(3000)
}

/**
 * This method sleep the main thread for specified duration
 *
 * @param duration Sleep Duration in Milliseconds
 */
private fun pause(duration: Int) {
    try {
        sleep(duration.toLong())
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}