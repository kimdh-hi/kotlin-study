package com.toy.core.`30-sequence`

/**
 * collection 에 대해 map, filter (컬렉션 함수) 등 중간연산 시 연산의 결과를 저장하기 위해 내부적으로 임시 컬렉션이 생성된다.
 *
 * sequence 의 경우 중간 연산의 결과를 임시 컬렉션에 저장하지 않고 연산을 미룬다. (lazy)
 * 실제 최종연산이 발생하는 시점에 지연된 연산을 실제 수행한다.
 */
fun main() {
  val p1 = Person("kim1", 28)
  val p2 = Person("kim2", 19)
  val p3 = Person("kim3", 25)
  val p4 = Person("kim4", 15)
  val p5 = Person("kim5", 30)
  val pList = listOf(p1 ,p2, p3, p4, p5)

  val list1 = pList
    .filter {
      println("filter: $it")
      it.age > 19
    } // filter 의 연산 결과는 임시 컬렉션에 저장된다.
    .map {
      println("map: $it")
      it.name
    }
  println(list1)
  println("====================")

  val list2 = pList.asSequence()
    .filter {
      println("filter: $it")
      it.age > 19
    }
    .map {
      println("map: $it")
      it.name
    }
    .toList() // toList 와 같은 최종연산 시점까지 컬렉션 연산을 지연한다.
  println(list2)
}

data class Person(
  val name: String,
  val age: Int
)