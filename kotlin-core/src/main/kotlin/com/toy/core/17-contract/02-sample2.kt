package com.toy.core.`17-contract`

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun main() {
  val name: String? = "kim"
  checkName(name)

  val person = Person(name)
  println(person)
}

@OptIn(ExperimentalContracts::class)
private fun checkName(name: String?) {
  contract { returns() implies (name != null) }

  if (name.isNullOrBlank()) {
    throw IllegalArgumentException("name cannot be null or blank.")
  }
}

data class Person(val name: String)
