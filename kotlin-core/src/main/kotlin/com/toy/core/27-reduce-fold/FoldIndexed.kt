package com.toy.core.`27-reduce-fold`

fun main() {
  val list = listOf(1, 2, 3, 4, 5)
  val result = list.foldIndexed(1) { index, acc, num ->
    if (index != 1) {
      acc + num
    } else {
      acc
    }
  }

  println(result)
}