package classes.android.rxJava

import io.reactivex.rxjava3.core.Observable
import java.util.Arrays
import java.util.concurrent.TimeUnit


fun main() {
    exMerge()
    exMergeArray()
    exMergeIterable()
    exMergeWith()
    exMergeInfinite()
}

/**
 * Uses the static merge function to merge Observables
 * This function can take at most 4 Observables
 */
private fun exMerge() {
    val oneToFive: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    val sixToTen: Observable<Int> = Observable.just(6, 7, 8, 9, 10)
    Observable.merge(sixToTen, oneToFive).subscribe(System.out::println)
}

/**
 * Uses the static mergeArray function to merge unlimited Observables, as it takes vararg
 */
private fun exMergeArray() {
    val oneToFive: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    val sixToTen: Observable<Int> = Observable.just(6, 7, 8, 9, 10)
    val elevenToFifteen: Observable<Int> = Observable.just(11, 12, 13, 14, 15)
    val sixteenToTwenty: Observable<Int> = Observable.just(16, 17, 18, 19, 20)
    val twentyOneToTwentyFive: Observable<Int> = Observable.just(21, 22, 23, 24, 25)
    Observable.mergeArray(
        oneToFive,
        sixToTen,
        elevenToFifteen,
        sixteenToTwenty,
        twentyOneToTwentyFive
    )
        .subscribe(System.out::println)
}

/**
 * Uses the static merge function to merge List of Observables
 */
private fun exMergeIterable() {
    val oneToFive: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    val sixToTen: Observable<Int> = Observable.just(6, 7, 8, 9, 10)
    val elevenToFifteen: Observable<Int> = Observable.just(11, 12, 13, 14, 15)
    val sixteenToTwenty: Observable<Int> = Observable.just(16, 17, 18, 19, 20)
    val twentyOneToTwentyFive: Observable<Int> = Observable.just(21, 22, 23, 24, 25)

    val observableList: List<Observable<Int>> = listOf<Observable<Int>>(
        oneToFive,
        sixToTen,
        elevenToFifteen,
        sixteenToTwenty,
        twentyOneToTwentyFive
    )
    Observable.merge(observableList).subscribe(System.out::println)
}

/**
 * All Observables has the mergeWith function, to easily merge it with another Observable
 * We can't merge with more than one Observable in this case
 */
private fun exMergeWith() {
    val oneToFive: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    val sixToTen: Observable<Int> = Observable.just(6, 7, 8, 9, 10)
    oneToFive.mergeWith(sixToTen).subscribe(System.out::println)
}

/**
 * This shows an implementation of the merge function with infinite Observables
 * As interval emits data as given time
 */
private fun exMergeInfinite() {
    val infinite1: Observable<String> = Observable.interval(1, TimeUnit.SECONDS)
        .map { item -> "From infinite1: $item" }
    val infinite2: Observable<String> = Observable.interval(2, TimeUnit.SECONDS)
        .map { item -> "From infinite2: $item" }
    infinite1.mergeWith(infinite2).subscribe(System.out::println)
    pause(6050)
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