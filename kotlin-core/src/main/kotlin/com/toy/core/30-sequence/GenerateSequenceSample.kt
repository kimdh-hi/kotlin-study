package com.toy.core.`30-sequence`

fun main() {

  val sampleSequence = generateSequence(0) { it + 1 }
  val sampleSequenceTo100 = sampleSequence.takeWhile { it <= 100 }
  println(sampleSequenceTo100.toList())
  println(sampleSequenceTo100.sum())
}