package com.toy.core.`56-nullable-condition`

fun main() {


  val test: Test? = null

  if (test?.flag == true) {
    println("true...")
  }

  /**
   * 이게 왜 안 될까.
   *
   * decompile 결과 null 과 true 을 비교함
   */

  test?.flag = true
  if (test?.flag == true) {
    println("true...")
  }
}

data class Test(
  var flag: Boolean?
)