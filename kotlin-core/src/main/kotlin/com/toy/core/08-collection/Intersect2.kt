package com.toy.core.`08-collection`

fun main() {
  val objectAList = listOf(
    IntersectObjectA("id1", "data1"),
    IntersectObjectA("id2", "data2"),
    IntersectObjectA("id3", "data3"),
  )

  val objectBList = listOf(
    IntersectObjectB("id1", "data1"),
    IntersectObjectB("id2", "data2"),
  )

  val intersectedList = objectAList.filter { a ->
    objectBList.any { b -> b.id == a.id }
  }

  println("Intersected List: $intersectedList")
}

data class IntersectObjectA(
  val id: String,
  val data: String
)

data class IntersectObjectB(
  val id: String,
  val data: String
)
