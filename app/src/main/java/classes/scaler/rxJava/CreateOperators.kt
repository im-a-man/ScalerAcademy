package classes.scaler.rxJava

import io.reactivex.rxjava3.core.Observable
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit


/**
 * Uses the map() operator to transform the value in between,
 * before it reaches to the Observer
 */
private fun mapOperator() {
    val observable: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    observable
        .map { item -> item * 2 }
        .subscribe(System.out::println)
}

/**
 * Uses the map() operator to transform the value in between,
 * before it reaches to the Observer and here map() emit different data type and
 * Observer just needs to adjust with it or accept the same type of emission
 */
private fun mapOperatorReturnsDifferentData() {
    val observable: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    observable
        .map { item -> "Hello World!" }
        .subscribe(System.out::println)
}

/**
 * Uses the filter() operator to filter out the value in between,
 * which doesn't meet the logic specified in filter,
 * and filter() may not emit no item if it no item match that criteria
 */
private fun filterOperator() {
    val observable: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    observable
        .filter { item -> item % 2 == 0 }
        .subscribe(System.out::println)
}

/**
 * Combines the map() and filter() operator together
 * and as map() and filter() both are nothing but an Observable
 * and also works like an Observer, so we can chain them,
 * but the order of operation does matter here.
 * Here filter() will kicks in first and map() will work on the filtered emission,
 * and not the whole emission in general
 */
private fun combineMapAndFilter() {
    val observable: Observable<Int> = Observable.just(1, 2, 3, 4, 5)
    observable
        .filter { item -> item % 2 == 0 }
        .map { item -> item * 2 }
        .subscribe(System.out::println)
}

/**
 * Used take(2) here, which emits only first 2 items and then complete
 */
private fun takeOperator() {
    Observable.just(1, 2, 3, 4, 5)
        .take(2)
        .subscribe(
            { o: Int? -> println(o) },
            { o: Throwable? -> println(o) }
        ) { println("Completed") }
}

/**
 * Used take(2) but with interval here, which emits items for the specified time interval only
 */
private fun takeWithInterval() {
    Observable.interval(300, TimeUnit.MILLISECONDS)
        .take(2, TimeUnit.SECONDS)
        .subscribe(
            { o: Long? ->
                println(
                    o
                )
            },
            { o: Throwable? ->
                println(
                    o
                )
            }
        ) { println("Completed") }
    pause(5000)
}

/**
 * This takeWhile() is like combination of filter and take,
 * the only difference is filter goes through all the items to check if the logic is true
 * whereas takeWhile() keep emitting only some logic is true
 * and it completes once it gets logic as false
 */
private fun takeWhileOperator() {
    Observable.just(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
        .takeWhile { item: Int -> item <= 3 }
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * skip(2) is just the opposite of take(2)
 * it will skip first values and emit remaining ones
 */
private fun skipOperator() {
    Observable.just(1, 2, 3, 4, 5)
        .skip(2)
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * skipWhile() is little is like combination of filter and skip,
 * the only difference is filter goes through all the items to check if the logic is true
 * whereas skipWhile() keep skipping items only if some logic true
 * and once the logic is false it emits remaining items without checking
 */
private fun skipWhileOperator() {
    Observable.just(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
        .skipWhile { item: Int -> item <= 3 }
        .subscribe { o: Int? ->
            println(
                o
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
        sleep(duration.toLong())
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}

/**
 * Used the distinct() to get the unique emission
 */
private fun distinctOperator() {
    Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
        .distinct()
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * Used the distinct based on the item's property to distinguish emission
 */
private fun distinctWithKeySelector() {
    Observable.just("foo", "fool", "super", "foss", "foil")
        .distinct { obj: String -> obj.length }
        .subscribe { s: String? ->
            println(
                s
            )
        }
}

/**
 * Used distinctUntilChanged() to avoid consecutive duplicate items one after another
 */
private fun distinctUntilChangedOperator() {
    Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
        .distinctUntilChanged()
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * Used distinctUntilChangedOperator() based on the item's property to distinguish the consecutive duplicate items
 */
private fun distinctUntilChangedWithKeySelector() {
    Observable.just("foo", "fool", "super", "foss", "foil")
        .distinctUntilChanged { obj: String -> obj.length }
        .subscribe { s: String? ->
            println(
                s
            )
        }
}

/**
 * Used defaultIfEmpty() operator so the observer will emit at least a default value
 * if the emission gets empty
 */
private fun useDefaultIfEmpty() {
    Observable.just(1, 2, 3, 4, 5)
        .filter { item: Int -> item > 10 }
        .defaultIfEmpty(100)
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * This will switch to some alternative Observable Source
 * if the emission gets empty
 */
private fun useSwitchIfEmpty() {
    Observable.just(1, 2, 3, 4, 5)
        .filter { item: Int -> item > 10 }
        .switchIfEmpty(Observable.just(6, 7, 8, 9, 10))
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * This used repeat operator to specify how many times emission witll repeat
 */
private fun useRepeat() {
    Observable.just(1, 2, 3, 4, 5)
        .repeat(3)
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * This uses scan operator to print the sum of the previously emitted item and current one that is going to emit
 */
private fun useScan() {
    Observable.just(1, 2, 3, 4, 5)
        .scan { accumulator: Int, next: Int -> accumulator + next }
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * This uses scan operator print the sum of the previously emitted item and current one that is going to emit,
 * but this also takes the initial emission into consideration by specifying an initial value
 */
private fun useScanWithInitialValue() {
    Observable.just(1, 2, 3, 4, 5)
        .scan(
            10
        ) { accumulator: Int, next: Int -> accumulator + next }
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * This used sorted operator to sort the operator
 */
private fun useSorted() {
    Observable.just(3, 5, 2, 4, 1)
        .sorted()
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * This used sorted operator along with Comparators reverse function
 * to sort and reverse the emission
 */
private fun useSortedWithOwnComparator() {
    Observable.just(3, 5, 2, 4, 1)
        .sorted(Comparator.reverseOrder())
        .subscribe { o: Int? ->
            println(
                o
            )
        }
}

/**
 * This used sorted operator along with Integer's compare function to
 * sort the emission based on their length
 */
private fun useSortedOnNonComparator() {
    Observable.just("foo", "john", "bar")
        .sorted { first: String, second: String ->
            Integer.compare(
                first.length,
                second.length
            )
        }
        .subscribe { s: String? ->
            println(
                s
            )
        }
}

/**
 * Used 'delay' operator to add a delay before the Observable start emission
 * Note: 'delay' doesn't delay each emission, instead it delays the start of the emission
 */
private fun createObservableUsingDelay() {
    Observable.just(1, 2, 3, 4, 5)
        .delay(3000, TimeUnit.MILLISECONDS)
        .subscribe { o: Int? ->
            println(
                o
            )
        }
    pause(5000)
}

/**
 * 'delay' operator doesn't add any delay before emitting error
 * This means the error is immediately emitted to it's subscribers by default
 * To delay the emission of error we need to pass delayError parameter as true
 */
private fun createObservableUsingDelayError() {
    Observable.error<Any>(Exception("Error"))
        .delay(3, TimeUnit.SECONDS, true)
        .subscribe(
            { o: Any? -> println(o) },
            { error: Throwable ->
                println(
                    error.localizedMessage
                )
            }
        ) { println("Completed") }
    pause(5000)
}

/**
 * contains operator checks if the number exist in the Observable emission
 * As soon as it gets the item it emits true or false otherwise
 */
private fun containsWithPremitive() {
    Observable.just(1, 2, 3, 4, 5)
        .contains(3)
        .subscribe { o: Boolean? ->
            println(
                o
            )
        }
}

/**
 * contains operator checks if the specific object exist in the Observable emission
 * based on the Object's hashcode
 * As soon as it gets the item it emits true or false otherwise
 */
private fun containsWithNonPremitive() {
    val user = User("mroydroid")
    Observable.just(user)
        .contains(user)
        .subscribe { o: Boolean? ->
            println(
                o
            )
        }
}

/**
 * a static class for demonstration purpose
 */
internal class User(var name: String)

fun main() {
    mapOperator()
    mapOperatorReturnsDifferentData()
    filterOperator()
    combineMapAndFilter()

    takeOperator()
    takeWithInterval()
    takeWhileOperator()
    skipOperator()
    skipWhileOperator()

    distinctOperator()
    distinctWithKeySelector()
    distinctUntilChangedOperator()
    distinctUntilChangedWithKeySelector()

    useDefaultIfEmpty()
    useSwitchIfEmpty()

    useRepeat()
    useScan()
    useScanWithInitialValue()

    useSorted()
    useSortedWithOwnComparator()
    useSortedOnNonComparator()

    createObservableUsingDelay()
    createObservableUsingDelayError()

    containsWithPremitive()
    containsWithNonPremitive()

    //Error Handling Operators

}