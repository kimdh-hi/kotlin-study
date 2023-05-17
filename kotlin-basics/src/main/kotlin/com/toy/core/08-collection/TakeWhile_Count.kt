package com.toy.basic.`08-collection`


/*
특정 조건을 만족하는 n개 원소가 있는 경우 순회를 멈추고 true 를 출력하고 싶음
 */
fun main() {
  val nums = (1..10).toList()
  val n = 3

  val result = nums.takeWhile {
    it > 1
  }.count() > n
  println(result)
}