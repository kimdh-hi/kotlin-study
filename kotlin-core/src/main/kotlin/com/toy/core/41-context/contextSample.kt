package com.toy.core.`41-context`

fun main() {
  val logger = Logger("main")
//  store("test1", logger)
//  store("test2", logger)
//  store("test3", logger)

  with(logger) {
    store("test1")
    store("test2")
    store("test3")
  }

}

class Logger(val name: String) {
  fun log(s: String) {
    println("[log] name: $s")
  }

  fun log2(s: String) {
    println("[log2] name: $s")
  }
}

//freeCompilerArgs = listOf("-Xcontext-receivers")
context(Logger)
fun store(s: String) {
  log("store.. $s")
  log2("store.. $s")
}

//fun Logger.store(s: String) {
//  log("store.. $s")
//}