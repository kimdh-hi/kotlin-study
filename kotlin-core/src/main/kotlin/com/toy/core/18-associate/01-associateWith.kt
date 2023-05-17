package com.toy.core.`18-associate`

fun main() {
  val myMap = mapOf(
    "key1" to "value1",
    "key2" to "value2",
    "key3" to "value2",
  )

  val result0 = myMap.keys
    .map { Pair(it, myMap[it]?.uppercase()) }
    .toMap()

  // map 에 대해 위와같이 value 값에 대한 작업이 필요한 경우 사용하면 좋을 듯
  val result = myMap.keys.associateWith { myMap[it]?.uppercase() }

  println(result0)
  println(result)
}