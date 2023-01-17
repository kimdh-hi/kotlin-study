package com.lecture.ch01.ch0101

import io.reactivex.rxjava3.processors.PublishProcessor

// hot publisher: consumer 는 구독한 시점부터 통지된 데이터들만 받을 수 있다.
// sub2 는 앞서 통지된 1,2 를 전달받을 수 없다.
fun main() {
  val processor = PublishProcessor.create<Int>()

  processor.subscribe { println("sub1: $it") }
  processor.onNext(1)
  processor.onNext(2)

  processor.subscribe { println("sub2: $it") }
  processor.onNext(3)
  processor.onNext(4)

  processor.onComplete()
}