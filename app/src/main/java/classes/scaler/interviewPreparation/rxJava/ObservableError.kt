package classes.scaler.interviewPreparation.rxJava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Supplier


/**
 * This is an example of illustration of the video series RxJava All In One.
 *
 * We've created Observable using Observable.error()
 * This factory method only provides exception to their Observers
 * through the onError()
 * This is specifically helpful if we don't want to throw exception directly,
 * so we can handle it gracefully in the onError()
 *
 */
fun main(args: Array<String>) {
    throwException()
    throwExceptionUsingCallable()
}

/**
 * This method uses Observable.error() to pass a new instance of exception directly
 * So their observers get the same exception instance everytime
 */
private fun throwException() {
    val observable: Observable<Exception> = Observable.error(Exception("An Exception"))
    observable.subscribe(System.out::println) { error ->
        System.out.println(
            "Error 1: " + error.hashCode()
        )
    }
    observable.subscribe(System.out::println) { error ->
        System.out.println(
            "Error 2: " + error.hashCode()
        )
    }
}

/**
 * This method uses Observable.error() to pass a new Instance of Callable
 * which takes an Exception as it's return type through lambda
 * So their Observers gets a new instance of exception on onError() every time
 */
private fun throwExceptionUsingCallable() {
    val observable: Observable<Exception> = Observable.error(Supplier {

        // We're printing this message to show that new instance gets created before
        // publishing the error to their Observers
        println("New Exception Created")
        Exception("An Exception")
    })
    observable.subscribe(System.out::println) { error ->
        System.out.println(
            "Error 1: " + error.hashCode()
        )
    }
    observable.subscribe(System.out::println) { error ->
        System.out.println(
            "Error 2: " + error.hashCode()
        )
    }
}