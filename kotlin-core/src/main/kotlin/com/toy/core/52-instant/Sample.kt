package com.toy.core.`52-instant`

import java.time.Instant

fun main() {
  val epoch = Instant.EPOCH
  println(epoch)

  println(Instant.MAX)
  println(Instant.MIN)

  println(Instant.now())
  println(Instant.now().epochSecond)
}