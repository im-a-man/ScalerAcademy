package classes.scaler.interviewPreparation.rxJava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.ObservableOperator
import io.reactivex.rxjava3.core.Observer

/**
We can create custom observables using 2 interfaces.
1=> ObservableOnSubscribe: This interface is used to create the emission logic for the observable.
It has a single method subscribe(ObservableEmitter<T> emitter),
where you define how to emit items to subscribers.

public interface ObservableOnSubscribe<T> {
void subscribe(ObservableEmitter<T> emitter) throws Exception;
}

2=> ObservableOperator: This interface is used to create custom operators that can transform,
filter, or manipulate the items emitted by an observable.
It has a single method apply(Observer<? super R> observer),
where you return an Observer that will be used to subscribe to the source observable.

public interface ObservableOperator<T, R> {
Observer<? super T> apply(Observer<? super R> observer) throws Exception;
}
 **/

fun main() {
    val fibonacciOf = 10
    // Creating a custom observable for the Fibonacci sequence
    val fibonacciObservable: Observable<Int> = Observable.create(FibonacciObservable(fibonacciOf))
    // Subscribing to the custom observable
    fibonacciObservable.subscribe(
        { value -> println("Next: $value") },
        { error -> System.err.println("Error: $error") }
    ) { println("Complete") }
}

// Custom Observable implementation for Fibonacci sequence
class FibonacciObservable(private val fibonacciOf: Int) : ObservableOnSubscribe<Int> {
    override fun subscribe(emitter: ObservableEmitter<Int>) {
        var first = 0
        var second = 1
        emitter.onNext(first)
        emitter.onNext(second)

        for (i in 2..fibonacciOf) {
            val next = first + second
            emitter.onNext(next)
            // Update values for the next iteration
            first = second
            second = next
        }
        emitter.onComplete()
    }
}


//Wrong implementation of ObservableOperator
class FibonacciObservableOperator(private val fibonacciOf: Int) : ObservableOperator<Int, Int> {
    override fun apply(observer: Observer<in Int>): Observer<in Int> {
        var first = 0
        var second = 1
        observer.onNext(first)
        observer.onNext(second)

        for (i in 2..fibonacciOf) {
            val next = first + second
            observer.onNext(next)
            // Update values for the next iteration
            first = second
            second = next
        }
        observer.onComplete()
        return observer
    }
}