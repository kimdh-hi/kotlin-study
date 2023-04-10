package com.toy.basic.`27-reduce`

fun main() {
  val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val result1 = numbers.reduce { total, num ->  total + num }
  println(result1)

  val result2 = numbers
    .parallelStream()
    .reduce { total, num -> total + num }
  println(result2.get())
}