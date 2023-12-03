package classes.android.rxJava

import io.reactivex.rxjava3.core.Observable

//Using flatMap we can change the emissions by providing new Observables
//And Using flatMap biFunction we can have the both emissions of
//The actual Observable and the flatMap function Observable,
//And can return accordingly by using both
fun main() {
    exFlatMap()
    exFlatMapBiFunction()
}

/**
 * This uses the flatMap to return desired Observables to the downstream
 * based on upstream emissions it gets in the Function
 */
private fun exFlatMap() {
    val observable: Observable<String> = Observable.just("foo", "bar", "jam")
    observable.flatMap { string ->
        if (string.equals("bar")) return@flatMap Observable.empty()
        Observable.fromArray(string.split(""))
    }.subscribe(System.out::println)
}

/**
 * This is similar to normal flatMap except the biFunction
 * which merge upstream emission with the emissions from the flatMap returned Observables from Function
 */
private fun exFlatMapBiFunction() {
    val observable: Observable<String> = Observable.just("foo", "bar", "jam")
    observable.flatMap({ string -> Observable.fromArray(string.split("")) }
    ) { actual, second -> actual.toString() + " " + second }
        .subscribe(System.out::println)
}