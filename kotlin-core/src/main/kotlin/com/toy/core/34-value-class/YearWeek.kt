package com.toy.core.`34-value-class`

import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.temporal.IsoFields
import java.time.temporal.TemporalAdjusters
import java.time.temporal.WeekFields
import java.util.Calendar.ZONE_OFFSET

/**
 * ISO-8601 YearWeek
 * - 01 주 내 연도의 첫번째 목요일이 존재
 * - 01 주 내 1월 4일이 존재,
 * - 시작 연도 내 01 주의 일 대부분(4일 이상)을 가진 첫번째 주, 그리고
 * - 12월 29일부터 1월 4일까지의 기간 내에 있는 월요일로 시작하는 주.
 * - 1월 1일이 월요일, 화요일, 수요일 혹은 목요일에 있다면, 1월 1일은 01 주 내에 포함
 * - 1월 1일이 금요일, 토요일 혹은 일요일이라면, 전년도의 52 주 혹은 53 주에 포함
 * - https://ko.wikipedia.org/wiki/ISO_8601
 */

@JvmInline
value class YearWeek(val value: String) {
  init {
    checkFormat()
  }

  private fun checkFormat() {
    if (value.length != 6) {
      throw IllegalArgumentException("yearWeek: $value (sample:202401)")
    }

    val year = value.substring(0, 4)
    val isYearValid = year.length == 4 && year.all { it.isDigit() }
    if (!isYearValid) {
      throw IllegalArgumentException("invalid year: $year")
    }

    val week = value.substring(4)
    val isWeekValid = week.length == 2 && week.all { it.isDigit() } && week.toInt() in 1..53
    if (!isWeekValid) {
      throw IllegalArgumentException("invalid week: $week")
    }
  }

  companion object {
    fun ofCurrent() = getYearWeek(Instant.now())

    fun getYearWeek(instant: Instant): YearWeek {
      val localDate = instant.atZone(ZoneOffset.UTC).toLocalDate()
      val year = localDate.get(IsoFields.WEEK_BASED_YEAR)
      val week = localDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)
      return YearWeek(String.format("%d%02d", year, week))
    }

    fun ofLastWeek(yearWeek: YearWeek): YearWeek {
      val year = yearWeek.value.substring(0, 4).toInt()
      val week = yearWeek.value.substring(4).toInt()

      val currentWeekStart = LocalDate.of(year, 1, 4)
        .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, week.toLong())
        .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))

      val previousWeekStart = currentWeekStart.minusWeeks(1)

      val previousYear = previousWeekStart.get(IsoFields.WEEK_BASED_YEAR)
      val previousWeek = previousWeekStart.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR)

      return YearWeek(String.format("%d%02d", previousYear, previousWeek))
    }
  }
}
