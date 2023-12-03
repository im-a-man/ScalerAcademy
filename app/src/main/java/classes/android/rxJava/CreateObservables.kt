package classes.android.rxJava

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.Callable
import java.util.concurrent.TimeUnit

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
    createObservableWithJust()//It takes between one to ten parameters. when you have a fixed set of items that you want to emit.
    createObservableFromIterable()//when you want to convert other data structures or objects into Observables.
    createObservableUsingCreate()//It allows you to manually emit items, errors, and completion signals using the Emitter provided in the subscribe method.
    createObservableUsingEmpty()
    createObservableUsingNever()
    createObservableUsingRange()
    createObservableUsingDefer()
    createObservableUsingFromCallable()//makes the lazy observable, when you want to convert other data structures or objects into Observables.
    createObservableUsingInterval()
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

fun createObservableUsingEmpty() {
    val observable = Observable.empty<Int>()
    observable.subscribe(
        ::println,
        ::println
    ) { println("createObservableUsingEmpty: OnCompleted") }
}

fun createObservableUsingNever() {
    val observable = Observable.never<Int>()
    observable.subscribe(
        ::println,
        ::println
    ) { println("createObservableUsingNever: OnCompleted") }
}

//Create a Observable with range() factory method
fun createObservableUsingRange() {//The Reactive Loop
    val observable = Observable.range(0, 10)
    observable.subscribe(::println)
    //----------------------------------------------------------------
    val start = 5
    var count = 2
    // it prints from start up to (start + count - 1)
    val observable1 = Observable.range(start, count)
    observable1.subscribe(::println)

    count = 3
    observable1.subscribe(::println)//Will get the same instance of observable that was created with count 2
    //This mean in range() we get same instance of observable for it's all observer
    //But this not the Reactive means we know...
}

//Create a Observable with defer() factory method
fun createObservableUsingDefer() {//The Reactive Loop
    val start = 5
    var count = 2
    val observable = Observable.defer {
        println("Returns new Observable with defer() factory method for each observers")
        Observable.range(start, count)
    }
    observable.subscribe({ onNext -> println(onNext) }, { onError -> }, { println("OnCompleted") })

    count = 3
    observable.subscribe(::println)
    //We'll see here that a new ObservableSource will be created for,
    //this new observer with new count value because of the defer
}


/**
 * This allows you to defer the execution of the function you
 * specify until an observer subscribes to the Observable.
 * That is to say, it makes the function "lazy."
 * */
fun createObservableUsingFromCallable() {
    val observable: Observable<Int> = Observable.fromCallable(
        Callable<Int> {
            println("Calling Method")
            getNumber()
        })
    observable.subscribe({ o: Int? -> println(o) })
    { error: Throwable -> println("An Exception Occurred" + error.localizedMessage) }
}

/**
 * This method returns an expression which is an int
 * @return a dummy expression (int)
 */
private fun getNumber(): Int {
    println("Generating Value")
    return 1 / 0
}

/**
 * Returns an Observable that emits a sequential number every specified interval of time.
 * delays the each emission.
 * */
fun createObservableUsingInterval() {
    //Runs on Computation Scheduler
    val observable: Observable<*> = Observable.interval(1, TimeUnit.SECONDS)

    observable.subscribe { item: Any ->
        println(
            "Observer 1: $item"
        )
    }

    pause(2000)

    observable.subscribe { item: Any ->
        println(
            "Observer 2: $item"
        )
    }

    pause(3000)
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