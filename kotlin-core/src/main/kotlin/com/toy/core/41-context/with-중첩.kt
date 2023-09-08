package com.toy.core.`41-context`

fun main() {
  val logger = LoggerV1("main")
  with(logger) {
    with(Api()) {
      log(get())
      log("test2")
      log("test3")
    }
  }
}

private class Api {
  fun get(): String = "api get"
}

private class LoggerV1(val name: String) {
  fun log(s: String) {
    println("name: $s")
  }
}