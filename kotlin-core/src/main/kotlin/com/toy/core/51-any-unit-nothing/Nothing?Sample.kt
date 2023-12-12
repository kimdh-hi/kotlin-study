package com.toy.core.`51-any-unit-nothing`

fun main() {
  val result = NothingSampleFunction(true)
}

private fun NothingSampleFunction(exception: Boolean): Nothing? {
  return if (exception) {
    throw IllegalArgumentException("exception...")
  } else {
    null
  }
}