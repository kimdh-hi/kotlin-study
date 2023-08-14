package com.toy.core.`40-generic-nonNull`

/**
 * 제네릭 타입은 null 을 허용
 * 명시적으로 제네릭 타입에 null 을 제한하고 싶은 경우 [T & Any] 사용 (non-nullable)
 */

fun main() {
  println(execute(null, 2))
  println(execute(1, 2))
//  println(execute(1, null)) // compiler-error
}

private fun <T> execute(a: T, b: T & Any): T & Any = a ?: b
