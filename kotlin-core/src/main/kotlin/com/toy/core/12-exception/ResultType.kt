package com.toy.core.`12-exception`

class ExternalService {

  fun checkOdd(num: Int): Result<Int> = if (num % 2 != 0) {
    Result.success(num)
  } else {
    Result.failure(IllegalArgumentException("$num is not odd..."))
  }
}

fun main() {
  val externalService = ExternalService()
  val result1 = externalService.checkOdd(3)
    .onFailure { e -> println("ExternalService.checkOdd exception... message=${e.message}") }
    .getOrThrow()
  println(result1)

  val result2 = externalService.checkOdd(2)
    .onFailure { e -> println("ExternalService.checkOdd exception... message=${e.message}") }
    .getOrNull()
  println(result2)
}