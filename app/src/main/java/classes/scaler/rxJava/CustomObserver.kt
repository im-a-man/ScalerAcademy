package classes.scaler.rxJava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

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
    // Subscribing to the custom observable using custom observer
    fibonacciObservable.subscribe(FibonacciObserver())
}

class FibonacciObserver : Observer<Int> {
    override fun onSubscribe(d: Disposable) {

    }

    override fun onError(error: Throwable) {
        System.err.println("Error: $error")
    }

    override fun onComplete() {
        println("Complete")
    }

    override fun onNext(value: Int) {
        println("Next: $value")
    }
}