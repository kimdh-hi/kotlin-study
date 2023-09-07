package com.toy.core.`41-context`

fun main() {
  val logger = Logger("main")
  with(logger) {
    with(Api()) {
      log(get())
      log("test2")
      log("test3")
    }
  }
}

class Api {
  fun get(): String = "api get"
}

class Logger(val name: String) {
  fun log(s: String) {
    println("name: $s")
  }
}