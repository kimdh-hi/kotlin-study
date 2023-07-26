package com.toy.core.`37-timezone`

import java.util.*

private const val AVAILABLE_TIMEZONE_REGEX = "^(Africa|America|Asia|Atlantic|Australia|Europe)/.*"

fun main() {
  val timeZoneVOs = mutableListOf<TimeZoneVO>()
  TimeZone.getAvailableIDs().map { timeZoneId ->
    val timeZone = TimeZone.getTimeZone(timeZoneId)
    if (timeZoneId.matches(Regex(AVAILABLE_TIMEZONE_REGEX))) {
      timeZoneVOs.add(TimeZoneVO.of(timeZone))
    }
  }

  timeZoneVOs.forEach {
    println(it)
  }
}

data class TimeZoneVO(
  val timeZone: String,
  val offset: Int,
) {
  companion object {
    fun of(timeZone: TimeZone) = TimeZoneVO(
      timeZone = timeZone.id,
      offset = timeZone.rawOffset / (60 * 60 * 1000)
    )
  }
}