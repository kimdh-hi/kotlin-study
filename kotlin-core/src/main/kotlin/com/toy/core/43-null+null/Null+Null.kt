package com.toy.core.`43-null+null`

// null + null 을 할 일이...

data class SomeTarget(
  val a: Int,
  val b: Int
)

operator fun SomeTarget?.plus(other: SomeTarget?): SomeTarget {
  val first = this ?: SomeTarget(0, 0)
  val second = other ?: SomeTarget(0, 0)
  return SomeTarget(first.a + second.a, first.b + second.b)
}
fun main() {

  // 기본적으로 public operator fun String?.plus(other: Any?): String 연산자 오버로딩을 사용
//  val result: String = null + null

  // 명시적으로 연산자 오버로딩 된 타입이 있다면 해당 타입을 결과로 사용
  val result = null + null
  println(result)
}