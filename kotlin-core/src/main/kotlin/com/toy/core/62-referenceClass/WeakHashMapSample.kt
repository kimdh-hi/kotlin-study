package com.toy.core.`62-referenceClass`

import java.util.WeakHashMap

fun main() {
  val hashMap = HashMap<String?, String>()
  var keyA1: String? = "a"
  val keyB1 = "b"
  hashMap[keyA1] = "aa"
  hashMap[keyB1] = "bb"


  val weakHashMap = WeakHashMap<String?, String>()
  var keyA2: String? = "a"
  val keyB2 = "b"
  weakHashMap[keyA2] = "aa"
  weakHashMap[keyB2] = "bb"

  keyA1 = null
  keyA2 = null

  System.gc()

  println(hashMap.entries)
  println(weakHashMap.entries) // gc 가 정상적으로 실행됐다면 참조가 제거된 'keyA2'는 제거된다.
}