package com.toy.core.`04-extension-function`

//todo: try-finally 확장함수로 간결하게 표현하고 싶은데 안 됨
fun main() {
  fun1().onFinally { fun2() }
}

private fun fun1() {
  println("fun1...")
  throw IllegalArgumentException("fun1 error...")
}

private fun fun2() {
  println("fun2...")
}

inline fun <T> T.onFinally(finallyBlock: () -> Unit): T {
  var exception: Throwable? = null
  try {
    return this
  } catch (e: Throwable) {
    exception = e
    throw e
  } finally {
    finallyBlock()
    exception?.let { throw it }
  }
}