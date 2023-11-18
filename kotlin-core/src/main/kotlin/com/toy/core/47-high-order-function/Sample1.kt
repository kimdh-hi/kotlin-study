package com.toy.core.`47-high-order-function`

private fun sample1(operator: (Int, Int) -> Int) {
  val result = operator(5, 5)
  println(result)
}

fun main() {
  sample1 { a, b -> a + b }
  sample1 { a, b -> a * b }
}