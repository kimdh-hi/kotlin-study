package com.toy.core.`08-collection`

fun main() {
  val list = listOf(
    GroupingByMultiColumnTest("a1", "b1", "c1", "d1", "e1"),
    GroupingByMultiColumnTest("a1", "b1", "c1", "d11", "e11"),
    GroupingByMultiColumnTest("a2", "b2", "c2", "d2", "e2"),
    GroupingByMultiColumnTest("a2", "b2", "c22", "d22", "e22"),
  )

  //그룹핑 대상 2개
//  val groupingResult = list.groupBy { it.data1 to it.data2 }
//    .map { (key, groupedList) ->
//      GroupingByMultiColumnTestList(key.first, key.second, groupedList)
//    }

  //그룹핑 대상 3개
  val groupingResult = list.groupBy { Triple(it.data1, it.data2, it.data3) }
    .map { (key, groupedList) ->
      GroupingByMultiColumnTestList(key.first, key.second, key.third, groupedList)
    }

  println(groupingResult)
}

data class GroupingByMultiColumnTestList(
  val data1: String,
  val data2: String,
  val data3: String,
  val datas: List<GroupingByMultiColumnTest>
)

data class GroupingByMultiColumnTest(
  val data1: String,
  val data2: String,
  val data3: String,
  val data4: String,
  val data5: String,
)