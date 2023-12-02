package com.toy.core.`48-constructor`

fun main() {
  val entity = ConstructorTestEntity("data1", SomeType.AA)
  val vo = ConstructorTestVO(entity)

  println(vo)
}

data class ConstructorTestEntity(
  val data1: String,
  val type: SomeType
)

data class ConstructorTestVO(
  val data1: String,
  val type: SomeType
) {

  init {
    println("init...") // 1
  }

  var data2: String = when (type) {
    SomeType.AA -> {
      println("AA") // 2
      "aa"
    }
    SomeType.BB -> {
      println("BB")
      "bb"
    }
  }

  constructor(entity: ConstructorTestEntity): this(entity.data1, entity.type) {
    println("constructor logic...") // 3
  }
}

enum class SomeType {
  AA, BB
}