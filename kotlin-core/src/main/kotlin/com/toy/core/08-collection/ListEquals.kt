package com.toy.core.`08-collection`

fun main() {
  val list1 = listOf("aaa", "bbb", "ccc")
  val list2 = listOf("bbb", "aaa", "ccc")
  val list3 = listOf("aaa", "aaa", "bbb", "ccc")
  val list4 = listOf<String>()

  println(list1 == list2) // xx
  println(list1 == list2) // xx
  println(list1.toTypedArray() contentEquals list2.toTypedArray()) // xx

  println(list1.isEqual(list2))
  println(list1.isEqual(list3))
  println(list1.isEqual(list4))
}

fun <T> List<T>.isEqual(list: List<T>): Boolean {
  if (this.size != list.size)
    return false

  return this.toSet() == list.toSet()
}