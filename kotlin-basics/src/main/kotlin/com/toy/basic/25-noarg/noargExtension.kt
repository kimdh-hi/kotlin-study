package com.toy.basic.`25-noarg`

import com.toy.basic.common.NoArg

@NoArg
data class NoArgTest(
  val a: String,
  val b: String
) {
  val ab by lazy { a + b }
}

fun main() {
  val noArgTest = NoArgTest::class.java.getConstructor().newInstance()
  println(noArgTest.ab)
}