package com.toy.core.`08-collection`

/**
 * immutableList 를 유지하며 기존 immutableList 에 특정 원소가 더해진 immutableList 생성
 */
fun main() {
  val alphabetList = listOf("a", "b", "c")
  val d: String? = "d"

  //as-is
  val results1 = alphabetList.toMutableList()
  d?.let { results1.add(it) }

  //to-be
  val results2 = buildList {
    addAll(alphabetList)
    d?.let { add(it) }
  }

  println(results1)
  println(results2)
}
