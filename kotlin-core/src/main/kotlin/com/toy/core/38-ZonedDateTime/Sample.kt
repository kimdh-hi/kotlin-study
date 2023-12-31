package com.toy.core.`38-ZonedDateTime`

import com.toy.core.`37-timezone`.TimezoneVO
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.util.*


private const val AVAILABLE_TIMEZONE_REGEX = "^(Africa|America|Asia|Atlantic|Australia|Europe)/.*"

fun main() {
  val timezoneVOS = mutableListOf<TimezoneVO>()
  TimeZone.getAvailableIDs().map { timeZoneId ->
    val timeZone = TimeZone.getTimeZone(timeZoneId)
    if (timeZoneId.matches(Regex(AVAILABLE_TIMEZONE_REGEX))) {
      timezoneVOS.add(TimezoneVO.of(timeZone))
    }
  }

  val localDateTime = LocalDateTime.now()
  val utcZone = ZonedDateTime.of(localDateTime, ZoneOffset.UTC)
  val zoneId = ZoneId.of("America/New_York")
  val convertedLocalDateTime = utcZone.withZoneSameInstant(zoneId).toLocalDateTime()

  println(localDateTime)
  println(convertedLocalDateTime)

  println("=========")
  println(LocalDateTime.now())
  println(ZonedDateTime.now(ZoneId.of("America/New_York")).toLocalDateTime())

}