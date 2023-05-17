package com.toy.core.`24-dsl`

/*
확장함수를 익명함수처럼 만들어 사용할 수 있다.
확장함수를 익명함수로 사용하는 경우 파라미터 앞에 리시버 타입(아래 예에서는 Int)이라고 부르는 타입이 붙는다.
==> 리시버를 가진 익명확장함수

리시버를 가진 익명확장함수를 호출하는 세 가지 방법
1. myPlusV2.invoke(1, 2)
2. myPlusV2(1, 2)
3. 1.myPlusV2(2)
 */
fun Int.myPlusV1(other: Int) = this + other
val myPlusV2 = fun Int.(other: Int) = this + other
val myPlusV3: Int.(Int) -> Int = { this + it }

fun main() {
  val myPlusV1Result = 10.myPlusV1(10)
  println(myPlusV1Result)

  val myPlusV2Result = 10.myPlusV2(10)
  println(myPlusV2Result)

  val myPlusV3Result = 10.myPlusV3(10)
  println(myPlusV3Result)
}