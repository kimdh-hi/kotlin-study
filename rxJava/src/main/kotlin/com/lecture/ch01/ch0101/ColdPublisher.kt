package com.lecture.ch01.ch0101

import io.reactivex.rxjava3.core.Flowable

fun main() {

  val flowable = Flowable.just(1, 2, 3, 4)

  flowable.subscribe { println("sub1: $it") }
  flowable.subscribe { println("sub2: $it") }
}