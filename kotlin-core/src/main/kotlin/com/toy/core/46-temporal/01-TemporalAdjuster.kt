package com.toy.core.`46-temporal`

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

fun main() {
  val localDate = LocalDate.of(2023, 11, 8)
  println(localDate)

  // 해당 일에서 가장 가까운 다음주 금요일
  val nextFridayAdjustedDate = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY))
  println(nextFridayAdjustedDate)

  // 해당 일에 해당하는 월의 마지막 date
  val lastDayOfMonthAdjustedDate = localDate.with(TemporalAdjusters.lastDayOfMonth())
  println(lastDayOfMonthAdjustedDate)
}