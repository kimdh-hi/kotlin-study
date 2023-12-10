package com.toy.core.`50-generic`.sample4

private open class Parent
private class Child1: Parent()
private class Child2: Parent()

//items: Array<out T> 와 동일한 효과
private fun someFunction1(items: Array<*>) {
//  items[0] = "aa" // 변경 불가
  println(items)
}

private fun someFunction(items: MutableList<*>) {
//  items.add("asd") // 변경 불가
  println(items)
}