package com.toy.basic.`08-collection`

// list2 의 data1 이 list1에 존재한다면 exists 를 true로 하고 싶음
fun main() {
  val list1 = listOf(1, 2, 3, 4, 5)
  val list2 = listOf(
    ListCompareTestVO(1, "1"),
    ListCompareTestVO(2, "2"),
    ListCompareTestVO(3, "3"),
    ListCompareTestVO(6, "6"),
  )

}

data class ListCompareTestVO(
  val data1: Int,
  val data2: String,
  val exists: Boolean = false
)