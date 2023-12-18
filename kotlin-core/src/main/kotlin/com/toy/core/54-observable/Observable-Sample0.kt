package com.toy.core.`54-observable`

import kotlin.properties.Delegates

var observableField: Int by Delegates.observable(0) { _, old, new ->
  println("$old -> $new")
}

fun main() {
  observableField = 10
}