package com.toy.core.`04-extension-function`


fun String.lastChar() = get(length-1)

fun main() {
  println("123".lastChar()) // -> 3
}

