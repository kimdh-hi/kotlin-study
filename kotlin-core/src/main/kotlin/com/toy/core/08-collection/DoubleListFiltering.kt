package com.toy.core.`08-collection`

fun main() {
  val list = listOf(
    DoubleListFilteringParent("data1", listOf(DoubleListFilteringChild(false, "data4"), DoubleListFilteringChild(false, "data5"), DoubleListFilteringChild(true, "data6"))),
    DoubleListFilteringParent("data2", listOf(DoubleListFilteringChild(true, "data5"))),
    DoubleListFilteringParent("data3", listOf(DoubleListFilteringChild(false, "data6"), DoubleListFilteringChild(true, "data7"))),
  )

//  val filteredList1 = list.filter { parent -> parent.children.any { child -> !child.deleted } }
//  filteredList1.forEach { println(it) }

  val filteredList2 = list
    .map { parent -> parent.copy(children = parent.children.filter { child -> !child.deleted }) }
    .filter { parent -> parent.children.isNotEmpty() }
  filteredList2.forEach { println(it) }

  println("==================================")

  val filteredList3 = mutableListOf<DoubleListFilteringParent>()
  for (parent in list) {
    val filteredChildren = parent.children.filter { child -> !child.deleted }
    if (filteredChildren.isNotEmpty()) {
      filteredList3.add(DoubleListFilteringParent(parent.data, filteredChildren))
    }
  }
  filteredList3.forEach { println(it) }

  println("==================================")

  val filteredList4 = list.mapNotNull { parent ->
    val filteredChildren = parent.children.filter { !it.deleted }
    if (filteredChildren.isNotEmpty()) DoubleListFilteringParent(parent.data, filteredChildren) else null
  }

  filteredList4.forEach { println(it) }
}

data class DoubleListFilteringParent(
  val data: String,
  val children: List<DoubleListFilteringChild>
)

data class DoubleListFilteringChild(
  val deleted: Boolean,
  val data2: String
)
