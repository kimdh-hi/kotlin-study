package com.toy.core.`44-invoke`

fun main() {

  operator fun String.invoke() {
    println(this)
  }

  "test"()
}

