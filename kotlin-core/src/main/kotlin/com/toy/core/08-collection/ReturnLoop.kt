package com.toy.core.`08-collection`

//continue 와 동일하게 동작
fun main() {
  val list = listOf(1, 2, 3, 4, 5)
  list.forEach {
    if (it % 2 == 0) return@forEach
    println(it)
  }
}
