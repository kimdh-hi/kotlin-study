package com.toy.core.`50-starProjections`

open class Parent
class Child1: Parent()
class Child2: Parent()

fun main() {
  val child1Array: Array<Child1> = arrayOf(Child1())
//  someFunction1(child1Array) // 컴파일 에러 발생

  val child1List: List<Child1> = listOf(Child1())
  someFunction2(child1List)

  val child1MutableList: MutableList<Child1> = mutableListOf(Child1())
//  someFunction3(child1MutableList) // 컴파일 에러
}

//파라미터로 받은 Array, MutableList 는 가변임
//parents[0] = Child2() 와 같은 코드로 조작 가능 (문제가 될 가능성이 있음)
//위 상황을 방지하기 위해 컴파일 에러 발생 (타입 안정성을 지키기 위함)

//List 의 경우 불변이므로 위와같은 side-effect 없음. 그래서 허용
//List 의 인터페이스 확인
//List<out E>

fun someFunction1(parents: Array<Parent>) {
  parents[0] = Child2()
  println(parents.size)
}

fun someFunction2(parents: List<Parent>) {
  println(parents.size)
}

fun someFunction3(parents: MutableList<Parent>) {
  println(parents.size)
}