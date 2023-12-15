package com.toy.core.`08-collection`

fun main() {
  val a = listOf("1", "2", "3", "4", "5")
  val b = listOf("1", "2", "5")
  println(a.intersect(b))
}