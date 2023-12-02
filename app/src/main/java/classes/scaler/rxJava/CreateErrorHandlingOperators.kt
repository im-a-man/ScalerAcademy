package classes.scaler.rxJava

import io.reactivex.rxjava3.core.Observable
import java.io.IOException
import java.util.concurrent.atomic.AtomicInteger

/**
 * The error goes to the doOnError lambda on the chain first, so we can handle it
 */
private fun exDoOnError() {
    Observable.error<Throwable>(Exception("This is an example error"))
        .doOnError { error -> System.out.println("Error: " + error.message) }
        .subscribe(
            System.out::println,
            { error -> System.out.println("Subscribed Error: " + error.message) }
        ) { println("Completed") }
}

/**
 * Whenever an error is found on the chain, it goes to the onErrorResumeNext
 * As this takes another Observable, the subscriber switch to that Observable
 * to skip the error
 */
private fun exOnErrorResumeNext() {
    Observable.error<Throwable>(Exception("This is an example error"))
        //.onErrorResumeNext(Observable.just(1, 2, 3, 4, 5))
        .subscribe(
            System.out::println,
            { error -> System.out.println("Subscribed Error: " + error.message) }
        ) { println("Completed") }
}

/**
 * We can return specific values based on the error type
 * As when we get the error it goes to the onErrorReturn lambda
 */
private fun exOnErrorReturn() {
    Observable.error<Throwable>(Exception("This is an example error"))
        .onErrorReturn { error ->
            if (error is IOException) return@onErrorReturn Throwable("This is an exception") else throw Exception(
                "This is an exception"
            )
        }
        .subscribe(
            System.out::println,
            { error -> System.out.println("Subscribed Error: " + error.message) }
        ) { println("Completed") }
}

/**
 * We can pass an alternative for the subscriber below the chain
 * Whenever error encounters it gives that specific alternative
 */
private fun exOnErrorReturnItem() {
    Observable.error<Throwable>(IOException("This is an example error"))
        .onErrorReturnItem(Throwable("This is an exception"))
        .subscribe(
            System.out::println,
            { error -> System.out.println("Subscribed Error: " + error.message) }
        ) { println("Completed") }
}

/**
 * This retry block try to analyze the error and take decision based on the error whether to retry or not
 * based on our logic inside that block
 */
private fun retryWithPredicate() {
    Observable.error<Any>(IOException("This is an example error"))
        .retry { error: Throwable? ->
            if (error is IOException) {
                println("retrying")
                return@retry true
            } else return@retry false
        }
        .subscribe(
            { o: Any? -> println(o) },
            { error: Throwable ->
                println(
                    "Subscribed Error: " + error.message
                )
            }
        ) { println("Completed") }
}

/**
 * This retry takes the number and tries to retry subscribing and getting the data from the observable again
 */
private fun exRetry() {
    Observable.error<Any>(java.lang.Exception("This is an example error"))
        .retry(3)
        .subscribe(
            { o: Any? -> println(o) },
            { error: Throwable ->
                println(
                    "Subscribed Error: " + error.message
                )
            }
        ) { println("Completed") }
}

/**
 * retryUntil depends on the boolean that we pass, it keeps retrying until we pass true based on the logic
 */
private fun exRetryUntil() {
    val atomicInteger = AtomicInteger()
    Observable.error<Any>(java.lang.Exception("This is an example error"))
        .doOnError { error: Throwable? ->
            println(atomicInteger.get())
            atomicInteger.getAndIncrement()
        }
        .retryUntil {
            println("Retrying")
            atomicInteger.get() >= 3
        }
        .subscribe(
            { o: Any? -> println(o) },
            { error: Throwable ->
                println(
                    "Subscribed Error: " + error.message
                )
            }
        ) { println("Completed") }
}

fun main() {
    //Error Handling Operators
    exDoOnError()
    exOnErrorResumeNext()
    exOnErrorReturn()
    exOnErrorReturnItem()

    //Error Handling Retry Operators
    retryWithPredicate()
    exRetry()
    exRetryUntil()
}
