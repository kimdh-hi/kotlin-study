package com.toy.core.`08-collection`

fun main() {

  val list = listOf(
    CompareByDescendingTest(1, 2),
    CompareByDescendingTest(1, 999),
    CompareByDescendingTest(2, 2),
    CompareByDescendingTest(2, 1),
    CompareByDescendingTest(2, 999),
    CompareByDescendingTest(2, -1),
  )

  val sortedList = list.sortedWith(
    compareByDescending<CompareByDescendingTest> { it.data1 }
      .thenByDescending { it.data2 }
  )

  println(sortedList)
}

data class CompareByDescendingTest(
  val data1: Int,
  val data2: Int
)
