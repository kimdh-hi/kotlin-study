package com.toy.core.`08-collection`

fun main() {
  val list1 = listOf("a", "b", "c")
  val list2 = mutableListOf(
    OnEachTestVO("a", "a1"),
    OnEachTestVO("b", "b1"),
    OnEachTestVO("c", "c1"),
    OnEachTestVO("d", "d1")
  )

  val result = list2
    .filter { list1.contains(it.data1) }
    .onEach {
      println("onEach: ")
      list2.remove(it)
    }
    .map { it.data2 }

  println(result)
}

data class OnEachTestVO(
  val data1: String,
  val data2: String,
)