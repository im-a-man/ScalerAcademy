package classes.scaler.interviewPreparation.rxJava

import io.reactivex.rxjava3.core.Observable

/**
=> Observable Creation Methods:
create
just
fromArray
fromIterable
fromCallable
fromFuture
fromPublisher

=> Observable Transformation Methods:
map
flatMap
concatMap
switchMap
buffer
groupBy
scan

=> Observable Filtering Methods:
filter
take
skip
distinct
elementAt
ignoreElements

=> Observable Combining Methods:
merge
concat
zip
combineLatest
join

=> Observable Utility Methods:
delay
timeout
doOnNext, doOnError, doOnComplete
materialize, dematerialize

=> Observable Conditional and Boolean Methods:
all
contains
sequenceEqual
amb

=> Observable Error Handling Methods:
onErrorResumeNext
retry

=> Observable Schedulers:
subscribeOn
observeOn
 */

fun main() {
    createObservableWithJust()
    createObservableFromIterable()
    createObservableUsingCreate()
}

/**
 * In this method we've created an integer observable
 * using Observable's static method just()
 * This method converts the items provided to an Observable
 * So later we can subscribe and get the item one by one to take action
 */
private fun createObservableWithJust() {
    val observable: Observable<Int> = Observable.just(1, 2, 3, 4, 5, 6)
    observable.subscribe(::println)
}

/**
 * In this method we've created an integer observable
 * using Observable's static method fromIterable()
 * This method converts anything which extend or implement iterable, to an observable
 * So later we can subscribe and get the item one by one to take action
 */
private fun createObservableFromIterable() {
    val list: List<Int> = mutableListOf(1, 2, 3, 4, 5)
    val observable: Observable<Int> = Observable.fromIterable(list)
    observable.subscribe(::println)
}

/**
 * In this method we've created an integer observable
 * using Observable's static method create()
 * Emitter here is an interface
 * By calling it's onNext(), onComplete() and onError() method
 * we can push events to our subscribers
 * So our subscribers can subscribe and get the item one by one to take action
 */
private fun createObservableUsingCreate() {
    val observable: Observable<Int> = Observable.create { emitter ->
        emitter.onNext(1)
        emitter.onNext(2)
        emitter.onNext(3)
        emitter.onNext(4)
        emitter.onNext(5)
        emitter.onNext(6)
        emitter.onComplete()
    }
    observable.subscribe({ item -> System.out.println(item) },
        { error -> System.out.println("There was error: " + error.getLocalizedMessage()) }
    ) { println("Completed") }
}