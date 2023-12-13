package com.toy.core.`52-instant`

import java.time.Instant
import java.time.ZoneId

// Instant timezone
fun main() {
  // Instant -> ZonedDateTime
  val now1 = Instant.now().atZone(ZoneId.of("Asia/Seoul"))
  println(now1)
  println(now1.toEpochSecond())
}