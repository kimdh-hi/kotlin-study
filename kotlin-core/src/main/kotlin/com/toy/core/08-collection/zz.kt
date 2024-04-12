package com.toy.core.`08-collection`

private val map = mapOf(
  "a" to arrayOf("1", "2", "3", "4"),
  "b" to arrayOf("1", "2", "3", "4")
)

fun main() {
  val result = map
    .mapValues { it.value.joinToString(",") }
    .entries.joinToString("&")

  println(result)
}