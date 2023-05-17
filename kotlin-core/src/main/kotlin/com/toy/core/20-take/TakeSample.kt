package com.toy.core.`20-take`

fun main() {

  // 수신객체에 대한 predicate 연산 후 true 라면 수신객체를 그대로 반환, false 라면 null 반환

  val vo = TakeSampleVO()

  println(if (vo.data1 == null) vo else null)
  println(vo.takeIf { vo.data1 == null })

  println(if (vo.data2.length <= 5) vo else null)
  println(vo.takeIf { it.data2.length <= 5 })
}

data class TakeSampleVO(
  val data1: String? = null,
  val data2: String = "data2"
)