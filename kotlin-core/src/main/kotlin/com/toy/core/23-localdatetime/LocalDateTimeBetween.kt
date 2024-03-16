package com.toy.core.`23-localdatetime`

import java.time.LocalDateTime

fun main() {
  val nowDate = LocalDateTime.now()
  val startDate = LocalDateTime.now().minusHours(1)
  val endDate = LocalDateTime.now().plusDays(1)

  val result1 = nowDate in startDate .. endDate
  val result2 = nowDate in LocalDateTime.now().plusHours(1) .. endDate

  println(result1)
  println(result2)
}