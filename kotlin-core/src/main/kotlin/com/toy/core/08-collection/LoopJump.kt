package com.toy.core.`08-collection`

fun main() {
  (1..10).forEach {
    if (it % 2 == 0) return@forEach
    println(it)
  }
}
