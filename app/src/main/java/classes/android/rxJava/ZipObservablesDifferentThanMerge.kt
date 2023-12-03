package classes.android.rxJava

import io.reactivex.rxjava3.core.Observable
import java.util.Arrays


fun main() {
    exZip()
    exZipWith()
    exZipIterable()
}

/**
 * Uses Zip operator to get the stream on the Zipper function
 */
private fun exZip() {
    val oneToFive: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    val sixToTen: Observable<Int> = Observable.range(6, 5)
    val elevenToFifteen: Observable<Int> =
        Observable.fromIterable(mutableListOf(11, 12, 13, 14, 15))
    Observable.zip(oneToFive, sixToTen, elevenToFifteen) { a, b, c -> a + b + c }
        .subscribe(System.out::println)
}

/**
 * Uses ZipWith operator on the Observable to easily zip One Observable with another
 */
private fun exZipWith() {
    val oneToFive: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    val sixToTen: Observable<Int> = Observable.fromIterable(mutableListOf(6, 7, 8, 9, 10))
    oneToFive.zipWith(sixToTen) { i: Int, i1: Int -> Integer.sum(i,i1) }
        .subscribe(System.out::println)
}

/**
 * Uses zipIterable operator which takes List of Observables and provides the zipped emission in an array
 */
private fun exZipIterable() {
    val oneToFive: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    val sixToTen: Observable<Int> = Observable.just(6, 7, 8, 9, 10)
    val elevenToFifteen: Observable<Int> = Observable.just(11, 12, 13, 14, 15)
    val observables: List<Observable<Int>> = Arrays.asList<Observable<Int>>(
        oneToFive, sixToTen, elevenToFifteen
    )
    Observable.zip(observables, Arrays::toString, true, 1)
        .subscribe(System.out::println)
}