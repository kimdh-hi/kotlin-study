package com.toy.core.`12-exception`

fun main() {
  runCatching {
    println("something...")
  }.also {
    println("finally")
  }.getOrElse { println("exception...") }

  println("==============")
  
  runCatching {
    println("something...")
    throw IllegalArgumentException("...")
  }.also {
    println("finally")
  }.getOrElse { println("exception...") }
}