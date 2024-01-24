package com.toy.core.`12-exception`

class ExternalService {

  // exception 처리를 클라이언트 코드에 위임
  // Result 는 결과가 성공인 경우는 반환값을 그대로 value로 하고 실패인 경우 Throwable 를 갖는다.
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