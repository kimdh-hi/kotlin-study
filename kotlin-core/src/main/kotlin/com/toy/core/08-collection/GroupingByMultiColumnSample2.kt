package com.toy.core.`08-collection`

fun main() {
  val list = listOf(
    GroupingTestDevice("ko", "type1", "data1"),
    GroupingTestDevice("ko", "type1", "data1"),
    GroupingTestDevice("jp", "type2", "data1"),
    GroupingTestDevice("jp", "type1", "data1"),
    GroupingTestDevice("en", "type2", "data1"),
    GroupingTestDevice("en", "type2", "data1"),
    GroupingTestDevice("en", "type4", "data1"),
    GroupingTestDevice("ko", "type2", "data1"),
    GroupingTestDevice("ko", "type1", "data1"),
  )

  list.groupBy { it.language to it.deviceType }.map { (key, devices) ->
    println("$key $devices")
  }
}

data class GroupingTestDevice(
  val language: String,
  val deviceType: String,
  val data: String,
)