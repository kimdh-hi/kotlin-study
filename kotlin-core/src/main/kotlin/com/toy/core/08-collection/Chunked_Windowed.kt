package com.toy.core.`08-collection`

fun main() {
  val list = listOf(1, 2, 3, 4, 5, 6)

  // [[1, 2, 3], [4, 5, 6]]
  val chunkedList = list.chunked(3)
  println(chunkedList)

  // [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6]]
  println(list.windowed(3))
}