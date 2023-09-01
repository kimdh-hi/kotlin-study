package com.toy.core.`38-ZonedDateTime`

import java.time.*
import java.time.zone.ZoneRulesException

object TimezoneUtils {

  fun adjustTimezone(date: LocalDateTime, zoneId: ZoneId): LocalDateTime {
    val zonedDateTime = ZonedDateTime.of(date, ZoneOffset.UTC)
    return zonedDateTime.withZoneSameInstant(zoneId).toLocalDateTime()
  }

  fun adjustTimezone(timestamp: Long, timezone: String): LocalDateTime {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), getZoneId(timezone))
  }
  private fun getZoneId(zoneId: String): ZoneId {
    return try {
      ZoneId.of(zoneId)
    } catch (e: ZoneRulesException) {
      try {
        ZoneId.of(ZoneId.SHORT_IDS[zoneId])
      } catch (e: Exception) {
        println("invalid zoneId...")
        throw e
      }
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
//  TimezoneUtils.getZoneId("America/New_York")
  val timestamp = System.currentTimeMillis()
  val adjustDate2 = TimezoneUtils.adjustTimezone(timestamp, "EST")
  println(adjustDate2)
  println(LocalDateTime.now())
}