package com.toy.core.`22-varargs`

// 같은 타입의 여러 값의 파라미터를 nullable 하게 받는 경우 vararg 를 사용하는 것도 좋은 듯
// nullable 타입은 가면 갈수록 불편할수도
fun main() {
  val result1 = `Varargs-List-TestFunc1`()
  val result2 = `Varargs-List-TestFunc2`()
}

fun `Varargs-List-TestFunc1`(vararg data: String): List<String> {
  if (data.isNotEmpty()) {
    //...
  }
  return data.toList()
}

fun `Varargs-List-TestFunc2`(data: List<String>? = null): List<String>? {
  data?.run {
    //...
  }
  return data
}