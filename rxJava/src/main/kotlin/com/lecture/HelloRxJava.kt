package com.lecture

import io.reactivex.rxjava3.core.Observable

fun main() {
  val observable = Observable.just("hello", "rxjava")
  observable.subscribe { println(it) }
}