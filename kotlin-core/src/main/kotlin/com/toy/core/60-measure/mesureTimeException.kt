package com.toy.core.`60-measure`

import kotlin.time.TimeSource.Monotonic.markNow

fun main() {
  val markNow = markNow()
  try {
    func()
  } finally {
    println(markNow.elapsedNow().inWholeMilliseconds)
  }
}

private fun func() {
  Thread.sleep(2000)
  throw IllegalArgumentException("ex")
}