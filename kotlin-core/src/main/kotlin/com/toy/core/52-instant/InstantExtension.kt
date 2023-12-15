package com.toy.core.`52-instant`

import java.time.Instant
import java.time.ZoneId

fun Instant.toAdjustedEpochSecond(zoneId: String? = null): Long {
  return if (zoneId != null) {
    val result = this.atZone(ZoneId.of(zoneId)).toEpochSecond()
    println(this.epochSecond)
    println(result)
    result
  } else {
    this.epochSecond
  }
}

fun main() {
  val result = Instant.now().toAdjustedEpochSecond("Asia/Seoul")
  println(result)
  println(Instant.ofEpochSecond(result))
}