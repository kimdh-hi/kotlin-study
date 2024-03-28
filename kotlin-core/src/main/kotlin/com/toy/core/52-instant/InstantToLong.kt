package com.toy.core.`52-instant`

import java.time.Instant

fun main() {
  val now = Instant.now()

  println(now.epochSecond)
  println(now.toEpochMilli())
}