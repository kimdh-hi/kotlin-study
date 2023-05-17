package com.toy.basic.`13-lazy-initialization`

fun main() {
  val test1 = LateInitInitializedCheckTest()
  test1.data = "data"
  test1.check()

  val test2 = LateInitInitializedCheckTest()
  test2.check()
}

class LateInitInitializedCheckTest {
  lateinit var data: String

  fun check() {
    if (this::data.isInitialized) {
      println("is initialized data=$data")
    } else {
      println("uninitialized...")
    }
  }
}