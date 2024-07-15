package com.toy.core.`64-random`

import org.apache.commons.math3.distribution.EnumeratedDistribution
import org.apache.commons.math3.util.Pair

fun main() {
  val list = listOf(
    WeightRandom("a", 0.01),
    WeightRandom("b", 0.1),
    WeightRandom("c", 0.9),
    WeightRandom("cc", 0.9),
    WeightRandom("ccc", 0.9),
    WeightRandom("d", 0.01),
    WeightRandom("e", 0.01),
    WeightRandom("f", 0.01),
    WeightRandom("g", 0.01),
    WeightRandom("h", 0.01),
    WeightRandom("i", 0.01),
  )

  for (i in 0..100) {
    val result = EnumeratedDistribution(
      list.map { Pair(it, it.weight) }
    ).sample()

    println(result)
  }
}

data class WeightRandom(
  val item: String,
  val weight: Double
)
