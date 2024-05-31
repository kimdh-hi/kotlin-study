package com.toy.core.kotlin_2_0

fun main() {
  func(AA())

}

private fun func(any: Any) {
  if (any is AA) {
    // smart casting
    any.aa()
  }
}

class AA {
  fun aa() {
    println("aa")
  }
}