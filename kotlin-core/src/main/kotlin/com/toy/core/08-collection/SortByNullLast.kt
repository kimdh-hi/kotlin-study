package com.toy.core.`08-collection`

fun main() {
  val list = listOf(9, 1, null, 3)
  println(list.sortedBy { it })
  println(list.sortedWith(nullsLast(compareBy { it })))
}
