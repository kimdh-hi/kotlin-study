package com.toy.core.`08-collection`

// zip 시 리스트 원소 수가 다른 경우 적은 쪽 기준으로 zip
fun main() {

  val list1 = listOf("a", "b", "c")
  val list2 = listOf(1, 2)

  // [("a", "1"), ("b", "2"), ("c", "3")]
  val zippedList = list1 zip list2 // list1.zip(list2)
  println(zippedList)

  list1.zip(list2) { alp, num ->
    println("$alp, $num")
  }

  val (list3, list4) = zippedList.unzip()
  println(list3)
  println(list4)
}
