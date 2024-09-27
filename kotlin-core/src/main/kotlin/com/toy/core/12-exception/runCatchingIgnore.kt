package com.toy.core.`12-exception`

fun main() {
  runCatching { exception() }
  runCatching { normal() }
  println("passed")
}

private fun exception() {
  throw Exception("ex")
}

private fun normal() {
  println("normal")
}
