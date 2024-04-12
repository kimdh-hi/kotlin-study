package com.toy.core.`59-string`

private const val FORMAT = "%s - %s"

fun main() {
  val result = String.format(FORMAT, "aaa", "bbb")
  println(result)

  val result2 = String.format(FORMAT, null, "bbb")
  println(result2)
}