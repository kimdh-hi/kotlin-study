package com.toy.core.`28-let`

fun main() {

  val a: String? = "aa"

  // a 가 Null 일 때 뿐만 아니라 let 블럭내에서 null 을 반활할 때에도 ?: 구문 실행됨
  val aa = a?.let { ForLetTestFunc2() } ?: println("is null")

  val b: String? = null
  val bb = b?.let { println("non-null") } ?: println("is null")
}
fun ForLetTestFunc() {
  throw NullPointerException()
}

fun ForLetTestFunc2(): Unit? {
  return null
}