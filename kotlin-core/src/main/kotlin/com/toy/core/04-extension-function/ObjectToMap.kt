package com.toy.core.`04-extension-function`

import java.time.LocalDateTime
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

//private fun <T : Any> toMap(target: T): Map<String, Any?> {
//  return (target::class as KClass<T>).memberProperties.associate { prop ->
//    prop.name to prop.get(target)?.let { value ->
//      if (value::class.isData) {
//        toMap(value)
//      } else {
//        value
//      }
//    }
//  }
//}

// 확장함수 스타일
fun <T : Any> T.toMap(): Map<String, Any?> {
  val clazz = this::class as KClass<T>
  return clazz.memberProperties.associate { prop ->
    prop.name to prop.get(this)?.let { value ->
      if (value::class.isData) {
        value.toMap()
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

//  val map1 = toMap(test)
//  println(map1)

  val map2 = test.toMap()
  println(map2)
}