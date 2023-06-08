package com.toy.core.`31-loop`

/**
 * 결과값을 누적하기 위한 var 타입의 변수를 사용하는 경우 sumOf 등으로 확장함수를 사용하면 누적을 위한 변수를 제거 할 수 있음
 */
fun main() {

  val list = listOf(1, 2, 3, 4, 5)

  var result1 = 0
  list.forEach {
    if (it % 2 == 0) {
      result1 += it
    }
  }
  println(result1)

  // sumOf
  val result2 = (1 until list.size).sumOf {
    if (list[it] % 2 == 0) {
      list[it]
    } else {
      0
    }
  }
  println(result2)
}