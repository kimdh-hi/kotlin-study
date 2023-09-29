package com.toy.core.`45-destructuring-declaration`

fun main() {
  val personKim = Person("kim", 28)
  val (name, age) = personKim

  val personKim2 = PersonNoneDataClass("kim", 28)
  val (name2, age2) = personKim2
}

data class Person(val name: String, val age: Int)

// data class 아닌 경우 구조 분해 선언을 사용하고 싶다면 별도 operator 함수를 선언해줘야 함 componentN ...
class PersonNoneDataClass(val name: String, val age: Int) {
  operator fun component1() = name
  operator fun component2() = age
}