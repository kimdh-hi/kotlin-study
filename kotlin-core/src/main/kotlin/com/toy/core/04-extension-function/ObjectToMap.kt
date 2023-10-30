package com.toy.core.`04-extension-function`

import java.time.LocalDateTime
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

private fun <T : Any> toMap(target: T): Map<String, Any?> {
  return (target::class as KClass<T>).memberProperties.associate { prop ->
    prop.name to prop.get(target)?.let { value ->
      if (value::class.isData) {
        toMap(value)
      } else {
        value
      }
    }
  }
}

data class Test(
  val data: String,
  val date: LocalDateTime,
  val number: Int,
  val inner: TestInner
)

data class TestInner(
  val data1: String,
  val data2: String
)

fun main() {
  val test = Test("data", LocalDateTime.now(), 10, TestInner("data1", "data2"))
  val map = toMap(test)
  println(map)
}