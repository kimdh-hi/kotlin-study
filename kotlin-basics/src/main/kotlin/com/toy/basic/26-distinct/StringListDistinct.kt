package com.toy.basic.`26-distinct`

fun main() {
  val list1 = listOf("aaa", "AAA")
  println(list1.distinct())
  println(list1.distinctBy { it.lowercase() })
}