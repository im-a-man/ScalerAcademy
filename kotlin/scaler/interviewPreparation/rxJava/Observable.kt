package classes.scaler.interviewPreparation.rxJava

import io.reactivex.rxjava3.core.Observable

fun main() {
    val list = Observable
        .just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .subscribe(::print)
}