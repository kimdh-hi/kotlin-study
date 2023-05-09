package com.toy.basic.`08-collection`

fun main() {

  val list = listOf(
    CollectionToMapWithMultipleKeyTestVO("a", "a", "1"),
    CollectionToMapWithMultipleKeyTestVO("a", "b", "2"),
    CollectionToMapWithMultipleKeyTestVO("a", "b", "3"),
    CollectionToMapWithMultipleKeyTestVO("a", "a", "3"),
  )

  val result1 = list.groupBy { CollectionToMapWithMultipleKeyTestKey(it.key1, it.key2) }
  println(result1)

  val result2 = list.groupBy { Pair(it.key1, it.key2) }
  println(result2)


}

data class CollectionToMapWithMultipleKeyTestVO(
  val key1: String,
  val key2: String,
  val data: String
)

data class CollectionToMapWithMultipleKeyTestKey(
  val key1: String,
  val key2: String
)