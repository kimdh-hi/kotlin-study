package com.toy.basic.`22-varargs`

import java.text.MessageFormat

fun main() {

  val test1 = "aa%s"
  println(String.format(test1, "a"))

  val test2 = "aa%s%s"
  println(String.format(test2, "a", "a"))

  val test3 = "aa{0}"
  println(MessageFormat.format(test3, "a"))

  val test4 = "aa{0}{1}"
  println(MessageFormat.format(test4, "a", "a"))

  val test5 = "a/b/%s/%s"
  println(String.format(test5, "1", "2"))


  val aaa = StringFormatTestEnum.AAA.getAAA("1", "2")
  val bbb = StringFormatTestEnum.BBB.getBBB("1", "2")

  println(aaa)
  println(bbb)
}

enum class StringFormatTestEnum(private val format: String) {
  AAA("a/b/{0}/{1}"),
  BBB("a/b/%s/%s");

  fun getAAA(vararg key: String): String {
    return MessageFormat.format(this.format, *key)
  }

  fun getBBB(vararg key: String): String {
    return String.format(this.format, *key)
  }
}

