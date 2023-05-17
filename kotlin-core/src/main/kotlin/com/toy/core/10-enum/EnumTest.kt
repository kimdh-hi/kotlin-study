package com.toy.core.`10-enum`

fun main() {
  println(Idp.valueOf("google".uppercase()))

  val topicA = Topic.TOPIC_A_FORMAT.ofPattern("key")
  val topicB = Topic.TOPIC_B_FORMAT.ofPattern("key1", "key2")

  println(topicA.format())
  println(topicB.format())
}

enum class Idp {
  GOOGLE, NAVER
}

enum class Topic(val format: String) {
  TOPIC_A_FORMAT("A/AA/%s"),
  TOPIC_B_FORMAT("B/BB/%s/%s");

  fun ofPattern(vararg keys: String): String {
    return String.format(this.format, *keys)
  }
}