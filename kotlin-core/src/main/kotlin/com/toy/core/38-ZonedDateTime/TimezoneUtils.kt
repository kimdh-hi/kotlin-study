package com.toy.core.`38-ZonedDateTime`

import java.time.*
import java.time.zone.ZoneRulesException

object TimezoneUtils {

  fun adjustTimezone(date: LocalDateTime, zoneId: ZoneId): LocalDateTime {
    val zonedDateTime = ZonedDateTime.of(date, ZoneOffset.UTC)
    return zonedDateTime.withZoneSameInstant(zoneId).toLocalDateTime()
  }

  fun adjustTimezone(timestamp: Long, zoneId: ZoneId): LocalDateTime {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), zoneId)
  }
  fun getZoneId(zoneId: String) {
    try {
      ZoneId.of(zoneId)
    } catch (e: ZoneRulesException) {
      // 존재하지 않는 zoneId 의 경우 ZoneRulesException 발생
      println("invalid zoneId...")
      throw IllegalArgumentException("invalid zoneId...")
    }
  }
}

fun main() {
  val now = LocalDateTime.now()
  val zoneId = ZoneId.of("America/New_York")

  val adjustDate = TimezoneUtils.adjustTimezone(now, zoneId)

  println(now)
  println(adjustDate)

  //####################

  println("===================================")
  TimezoneUtils.getZoneId("America/New_York")
  val timestamp = System.currentTimeMillis()
  val adjustDate2 = TimezoneUtils.adjustTimezone(timestamp, zoneId)
  println(adjustDate2)
  println(LocalDateTime.now())
}