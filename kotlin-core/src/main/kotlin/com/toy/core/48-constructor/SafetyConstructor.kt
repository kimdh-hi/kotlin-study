package com.toy.core.`48-constructor`

/**
 * private constructor + companion object + operator fun invoke
 * - 생성자 통한 객체 생성시 조건 적용
 */

class SafetyConstructorEntity private constructor(
  var id: String? = null, // 외부에서 생성x (jpa entity로 가정)
  val name: String, // blank 불가
  val email: String, // black 불가, email format
  val initial: Boolean = false // 초기값 강제
) {
  companion object {
    operator fun invoke(name: String, email: String): SafetyConstructorEntity {
      require(name.isNotBlank()) { "name must not be blank" }
      require(email.isNotBlank()) { "email must not be blank" }
      return SafetyConstructorEntity(name = name, email = email)
    }
  }
}

fun main() {
  val entity = SafetyConstructorEntity(name = "name", email = "email")
  val invalidEntity = SafetyConstructorEntity(name = " ", email = "email")
}
