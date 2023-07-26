package com.toy.core.`37-timezone`

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

object TimezoneDateUtils {

  fun adjustTimezone(date: LocalDateTime, zoneId: ZoneId): LocalDateTime {
    val zonedDateTime = ZonedDateTime.of(date, ZoneOffset.UTC)
    return zonedDateTime.withZoneSameInstant(zoneId).toLocalDateTime()
  }
}

fun main() {
  val now = LocalDateTime.now()
  val zoneId = ZoneId.of("America/New_York")

  val adjustDate = TimezoneDateUtils.adjustTimezone(now, zoneId)

  println(now)
  println(adjustDate)
}