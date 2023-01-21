package com.lecture.ch01.ch0101

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {

  Flowable.interval(300L, TimeUnit.MILLISECONDS)
    .doOnNext { println("doOnNext: $it") }
    .onBackpressureDrop { println("drop... $it") }
    .observeOn(Schedulers.computation(), false, 1)
    .subscribe(
      {
        Thread.sleep(1000L)
        println("**[consume]... $it")
      },
      { println(it) }
    )

  Thread.sleep(3000L)
}