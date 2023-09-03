package com.toy.core.`08-collection`

fun main() {
  val numbers = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))

  val result1 = numbers.flatten()
  println(result1)
}

private fun func1(numbers: List<Int>) = numbers