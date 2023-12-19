package com.toy.core.`54-observable`

import kotlin.properties.Delegates

// Delegates.observable 과 다르게 리턴값이 있음(Boolean)
// 리턴값이 TRUE 인 경우에만 onChange 콜백함수 호출

var vetoableField: Int by Delegates.vetoable(0) { _, old, new ->
  println("$old -> $new")
  new % 2 == 0
}

fun main() {
  vetoableField = 2
  vetoableField = 1
}

