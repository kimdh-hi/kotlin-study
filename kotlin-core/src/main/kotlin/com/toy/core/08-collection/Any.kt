package com.toy.core.`08-collection`

fun main() {
  val list1 = listOf(1, 3, 5, 7, 9)
  val list2 = listOf(1, 3, 5, 7, 9, 10)

  println(list1.any { it % 2 == 0 })
  println(list2.any { it % 2 == 0 })
}