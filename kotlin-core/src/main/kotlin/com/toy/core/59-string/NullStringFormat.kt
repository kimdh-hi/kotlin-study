package com.toy.core.`59-string`

fun main() {
  val width: Int? = null
  val height: Int? = null

  val result = "${width ?: ""}x${height ?: ""}"

  println(result)
}