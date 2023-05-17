package com.toy.core.`27-reduce-fold`

fun main() {
  val list1 = emptyList<Int>()

//   exception => UnsupportedOperationException: Empty collection can't be reduced.
//  val result1 = list1.reduce { total, n -> total + n }
//  println(result1)

  // 확장함수로 제공되는 reduce 가 아닌 Stream 의 reduce는 초기값 지정 가능
  val result2 = list1
    .stream()
    .reduce(0) { total, n -> total + n }
  println(result2)

  val result3 = list1.fold(0) { total, n -> total + n}
  println(result3)
}