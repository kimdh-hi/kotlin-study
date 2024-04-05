package com.toy.core.`12-exception`

import java.util.UUID

fun main() {
  runCatching {
    throw RuntimeException("ex...")
  }.onFailure {
    println("onFailure. message=${it.message}")
  }

  println(UUID.randomUUID().toString())
  println(UUID.randomUUID().toString())
}