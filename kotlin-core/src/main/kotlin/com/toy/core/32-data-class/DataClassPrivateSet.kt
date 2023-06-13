package com.toy.core.`32-data-class`

// data class 이지만 equals and hashcode 직접 생성해줘야함
// data class 는 기본적으로 주 생성자의 프로퍼티로 equals and hashcode 정의
data class Person1(
  var name: String
) {
  var age: Int = 1
    private set

  constructor(name: String, age: Int): this(name)

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as Person1

    if (name != other.name) return false
    return age == other.age
  }

  override fun hashCode(): Int {
    var result = name.hashCode()
    result = 31 * result + age
    return result
  }
}