package com.toy.lincheck

import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import org.junit.jupiter.api.Test


class SampleTest1 {

  val counter = Counter()

  @Operation
  fun inc() = counter.inc()

  @Operation
  fun get() = counter.get()

  @Test
  fun stressTest() = StressOptions().check(this::class)
}

class SampleTest2 {

  val counter = SynchronizedCounter()

  @Operation
  fun inc() = counter.inc()

  @Operation
  fun get() = counter.get()

  @Test
  fun stressTest() = StressOptions().check(this::class)
}

data class SynchronizedCounter(
  @Volatile
  var value: Int = 0
) {
  fun inc() = synchronized(this) {
    ++value
  }

  fun get() = value
}

data class Counter(
  var value: Int = 0
) {
  fun inc() = ++value

  fun get() = value
}