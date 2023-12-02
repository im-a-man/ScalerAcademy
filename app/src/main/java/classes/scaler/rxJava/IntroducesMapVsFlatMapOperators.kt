package classes.scaler.rxJava

import io.reactivex.rxjava3.core.Observable

fun main() {
    exMap()
    exFlatMap()
    exMapWithObservable()
}

/**
 * This uses the map operators to change the emission in between before it reaches to it's subscriber
 * In case of map we can return anything.
 */
private fun exMap() {
    val observable: Observable<String> = Observable.just("foo", "bard", "james")
    observable
        .map { item -> item.toUpperCase() }
        .subscribe(System.out::println)
}

/**
 * This uses the flatMap to merge returned observables based on the emission
 * In case of flatMap we must return an observable
 */
private fun exFlatMap() {
    val observable: Observable<String> = Observable.just("foo", "bar", "jam")
    observable.flatMap { item -> Observable.fromArray(item.split("")) }
        .subscribe(System.out::println)
}

/**
 * This uses map operators to convert the stream in between to Observables
 * and for obvious reasons the subscribers get the Observable object instead
 * In case of map we can return anything,
 * But if we return an observable then we get that object address string only.
 */
private fun exMapWithObservable() {
    val observable: Observable<String> = Observable.just("foo", "bar", "jam")
    observable.map { item -> Observable.fromArray(item.split("")) }.subscribe(System.out::println)
}