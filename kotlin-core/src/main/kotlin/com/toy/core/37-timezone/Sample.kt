package com.toy.core.`37-timezone`

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

  timezoneVOS.forEach {
    println(it)
  }
}

data class TimezoneVO(
  val timeZone: String,
  val offset: Int,
) {
  companion object {
    fun of(timeZone: TimeZone) = TimezoneVO(
      timeZone = timeZone.id,
      offset = timeZone.rawOffset / (60 * 60 * 1000)
    )
  }
}