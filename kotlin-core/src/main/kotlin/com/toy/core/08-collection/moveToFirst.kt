package com.toy.core.`08-collection`

import java.util.LinkedList

fun main() {
//  val targetIndex = list.indexOfFirst { it == target }
//  val temp = list[targetIndex]
//  list.removeAt(targetIndex)
//  list.addFirst(temp)

  list.sortByDescending { it == target }
  println(list)
}

private const val target = "aa"
private val list = mutableListOf("a", "b", "c", "d", "aa")
//private val list = LinkedList<String>().apply {
//  addAll(listOf("a", "b", "c", "d", "aa"))
//}