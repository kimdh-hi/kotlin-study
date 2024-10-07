package com.toy.core.`08-collection`

fun main() {
  val list = listOf(
    Person("c", 888),
    Person("a", 999),
    Person("a", 888),
    Person("b", 444),
    Person("b", 111),
  )

  // name -> age 순 정렬 안 됨 age 정렬만 됨
  val result1 = list
    .sortedBy { it.name }
    .sortedBy { it.age }
  println(result1)

  val result2 = list
    .sortedWith(compareBy({ it.name }, { it.age }))
  println(result2)
}

data class Person(
  val name: String,
  val age: Int,
)
