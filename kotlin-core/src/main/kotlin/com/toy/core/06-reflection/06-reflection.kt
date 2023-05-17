package com.toy.core.`06-reflection`

import org.jetbrains.annotations.NotNull

fun main() {
  reflectionTest(TestVO("testId", "testName"))
}

inline fun <reified T> reflectionTest(vo: T) {
  val constructors = T::class.constructors
}

data class TestVO(
  @NotNull
  val id: String,
  val name: String
)