package com.toy.core.`23-localdatetime`

import java.time.Duration
import java.time.LocalDateTime

fun main() {
  val endDate = LocalDateTime.of(2023, 4, 1, 1, 3, 0)
  val startDate = LocalDateTime.of(2023, 4, 1, 1, 1, 0)

  val resultDuration = Duration.between(startDate, endDate)
  println(resultDuration.seconds)
}