package com.toy.core.`50-generic`.sample2

private open class Parent
private class Child1: Parent()
private class Child2: Parent()

//out T 공병성
//컴파일러의 타입 안정성을 위한 제약을 풀기위한 장치
//타입 안정성 제약을 풀고, 파라미터로 받을 수 있음
//단, read-only 임
//MutableList<out Parent> 도 MutableList 이지만 read-only로 처리됨

fun main() {
  val child1Array: Array<Child1> = arrayOf(Child1())
  someFunction1(child1Array)

  val child1MutableList: MutableList<Child1> = mutableListOf(Child1())
  someFunction2(child1MutableList)
}


private fun someFunction1(parents: Array<out Parent>) {
  println(parents.size)
}
private fun someFunction2(parents: MutableList<out Parent>) {
//  parents.add(Child2()) // compile error
  println(parents.size)
}