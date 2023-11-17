package classes.scaler.interviewPreparation.rxJava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable


/**
 * This is an example of illustration of the video series RxJava All In One.
 *
 * We've created Cold Observable using Observable.just()
 * and paused the thread to prove whether it is really Cold Observable
 * and we also created Hot Observable using by converting a Cold Observable
 * to a Hot Observable using Connectable Observable
 *
 */
fun main(args: Array<String>) {
    createColdObservable()
    createHotAndConnectableObservable()
}

/**
 * Creates Cold Observable using Observable.just()
 * Because each and every onNext() gets their separate emission
 */
private fun createColdObservable() {
    val observable: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    observable.subscribe { item -> println("Observer 1: $item") }
    pause(3000)
    observable.subscribe { item -> println("Observer 2: $item") }
}

/**
 * Creates a Hot Observable
 * The moment we call the publish() method on Observable.just()
 * It Converts the Observable to a Connectable Observable
 * Connectable Observable doesn't start it's emission right after you subscribe
 * The moment we call connect() method it starts emission
 * Any Observer which subscribes after calling connect() misses emissions
 */
private fun createHotAndConnectableObservable() {
    val observable: ConnectableObservable<Int> =
        Observable.just(1, 2, 3, 4, 5)
            .publish()
    observable.subscribe { item: Int ->
        println(
            "Observer 1: $item"
        )
    }
    observable.connect()

    //This will misses the emissions because it subscribed later after emissions started,
    // it can not get previous emissions, So This is called Hot and Connectable Observable
    observable.subscribe { item: Int ->
        println(
            "Observer 2: $item"
        )
    }
}

/**
 * This method sleep the main thread for specified duration
 *
 * @param duration Sleep Duration in Milliseconds
 */
private fun pause(duration: Int) {
    try {
        Thread.sleep(duration.toLong())
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}