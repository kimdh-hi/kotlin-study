package com.toy.core.`0-a`

import java.io.File
import java.time.LocalDate
import java.time.LocalDateTime

fun main() {

}



fun MutableList<Int>.swap(index1: Int, index2: Int) {
  val tmp = this[index1] // 'this' corresponds to the list
  this[index1] = this[index2]
  this[index2] = tmp
}
