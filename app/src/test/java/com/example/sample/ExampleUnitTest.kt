package com.example.sample

import io.reactivex.Observable
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val ob1 = Observable.error<Int>(java.lang.IllegalArgumentException()).onErrorResumeNext(Observable.empty<Int>())
        val ob2 = Observable.just(2)

        Observable.concat(ob1, ob2)
            .subscribe({
                println("onNext: $it")
            }, {
                println("onError: $it")
            }, {
                println("onComplete")
            })

        Thread.sleep(200)
    }
}