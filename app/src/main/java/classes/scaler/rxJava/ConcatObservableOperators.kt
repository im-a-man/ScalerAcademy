package classes.scaler.rxJava

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

/**

 * */

fun main() {
    //Concat and Merge are same but when want to keep the ordering
    //of the Observable emissions as its been concat-ed, then we use concat method.
    exConcat()
    exConcatWith()//Emissions will be ordered if we use concat instead of merge
    exConcatMap()
}

fun exConcat() {
    val observable1 = Observable.just(1, 2, 3, 4, 5)
    val observable2 = Observable.range(6, 5)

    val dispose = Observable.concat(observable1, observable2).subscribe(::println)
}

fun exConcatWith() {
    val observable1 = Observable
        .interval(1, TimeUnit.SECONDS)
        .take(5)
        .map { item -> "Observable-1: $item" }
    val observable2 = Observable
        .interval(300, TimeUnit.MILLISECONDS)
        .map { item -> "Observable-2: $item" }

    val dispose = observable1
        .concatWith(observable2)
        .subscribe(::println)

    pause(10000)
}

fun exConcatMap() {
    val observable = Observable
        .just("foo", "bar", "jam")
        .concatMap { item -> Observable.fromArray(item.split("")) }
        .subscribe(::println)
    //If we use flatMap here the emission ordering will not be maintained.
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