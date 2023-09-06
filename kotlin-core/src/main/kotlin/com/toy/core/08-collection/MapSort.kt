package com.toy.core.`08-collection`

fun main() {
  // 외부 api 의해 응답된 children
  val c1 = Child(id = 1, parentId = 5)
  val c1_1 = Child(id = 11, parentId = 5)
  val c2 = Child(id = 2, parentId = 4)
  val c2_2 = Child(id = 22, parentId = 4)
  val c3 = Child(id = 3, parentId = 3)
  val c4 = Child(id = 4, parentId = 2)
  val c5 = Child(id = 5, parentId = 1)
  val children = listOf(c1, c1_1, c2, c2_2, c3, c4, c5)

  // 외부 api 에 의해 정렬된 parents
  val sortedParents = (1..5).map { Parent(it) }

//  val parentChildMap = mutableMapOf<Int, List<Child>>()
//  sortedParents.map { parent ->
//    parentChildMap[parent.id] = children.filter { it.parentId == parent.id }
//  }

  val parentChildMap = sortedParents.associate { parent ->
    parent.id to children.filter { it.parentId == parent.id }
  }

  println(parentChildMap)
}

/*
{
  ["parentId": 1, "children": ["id": 5]],
  ["parentId": 2, "children": ["id": 4]],
  ["parentId": 3, "children": ["id": 3]],
  ["parentId": 4, "children": ["id": 2, "id": 22]],
  ["parentId": 5, "children": ["id": 1, "id": 11]],
  ["parentId": 5, "children": ["id": 1, "id": 1]]
}
 */

data class Parent(
  val id: Int,
)

data class Child(
  val id: Int,
  val parentId: Int,
)