package com.toy.core.`08-collection`

fun main() {
  val list = listOf(
    DoubleListFilteringParent("data1", listOf(DoubleListFilteringChild("data1", "data4"))),
    DoubleListFilteringParent("data2", listOf(DoubleListFilteringChild("data1", "data5"))),
    DoubleListFilteringParent("data3", listOf(DoubleListFilteringChild("data2", "data6"))),
  )

  val filteredList = list.filter { parent ->
    parent.children.any { child -> child.data1 == "data1" }
  }

  filteredList.forEach { println(it) }
}

data class DoubleListFilteringParent(
  val data: String,
  val children: List<DoubleListFilteringChild>
)

data class DoubleListFilteringChild(
  val data1: String,
  val data2: String
)
