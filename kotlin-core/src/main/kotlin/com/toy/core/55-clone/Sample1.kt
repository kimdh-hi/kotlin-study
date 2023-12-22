package com.toy.core.`55-clone`

fun main() {
  val c1 = CloneTest("data1")
  val c2 = c1 // 얕은복사
  c1.data = "data2"
  println(c1)
  println(c2)
  println("============")

  val c3 = c1.copy() // data class 의 경우 copy 함수로 깊은 복사 가능
  c1.data = "data3"
  println(c1)
  println(c2)
  println(c3)
  println("============")

  val c2_1 = CloneTest2("data1")
  val c2_2 = c2_1.clone()
  c2_1.data = "data2"
  println(c2_1)
  println(c2_2)
}

data class CloneTest(
  var data: String
)

class CloneTest2(
  var data: String
): Cloneable {
  public override fun clone(): CloneTest2 {
    return super.clone() as CloneTest2
  }

  override fun toString(): String {
    return "CloneTest2(data='$data')"
  }
}