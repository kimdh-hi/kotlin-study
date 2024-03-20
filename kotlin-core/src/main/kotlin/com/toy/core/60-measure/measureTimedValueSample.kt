package com.toy.core.`60-measure`

import java.lang.Thread.sleep
import kotlin.time.measureTimedValue

fun main() {
  val timedValue = measureTimedValue { func() }

  println(timedValue.value)
  println(timedValue.duration.inWholeMilliseconds)

  val timedValue2 = measureTimedValue { func2(3) }
  println(timedValue2.value)
  println(timedValue2.duration.inWholeMilliseconds)
}

private fun func(): String {
  sleep(1000)
  return "done"
}

private fun func2(a: Int): String? {
  sleep(1000)
  return if (a % 2 == 0) "success" else null
}