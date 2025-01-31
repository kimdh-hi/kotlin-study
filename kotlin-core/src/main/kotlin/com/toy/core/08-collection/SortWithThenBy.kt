package com.toy.core.`08-collection`

fun main() {
  val test1 = SortTest(1, 1)
  val test2 = SortTest(2, 2)
  val test3 = SortTest(3, 3)
  val test4 = SortTest(4, 5)
  val test5 = SortTest(4, 1)
  val testNull = SortTest(null, 1)

  val list = listOf(test4, test3, test5, test2, test1, testNull)

//  val sortedList = list.sortedWith(
//    Comparator.nullsLast(compareBy<SortTest> { it.data1 })
//      .thenBy { it.data2 }
//  )

  val sortedList = list.sortedWith(
    compareBy<SortTest> { it.data1 == null }  // null 체크를 먼저
      .thenBy { it.data1 }                  // 그 다음 data1 정렬
      .thenBy { it.data2 }                  // 마지막으로 data2 정렬
  )

  println(sortedList)
}

data class SortTest(
  val data1: Int?,
  val data2: Int?
)
