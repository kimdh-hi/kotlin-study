package com.toy.core.`25-noarg`

import com.toy.core.common.NoArg

/*
noArg {
    annotation("com.toy.basic.common.NoArg")
    invokeInitializers = true
}

invokeInitializers = true 설정시 아래 코드 NPE 발생하지 않음.
 */
@NoArg
data class NoArgTest(
  val a: String,
  val b: String
) {
  val ab by lazy { a + b }
}

@NoArg
data class NoArgWithEnum(
  val data: NoArgTestEnum
)

enum class NoArgTestEnum {
  AA, BB, CC
}

fun main() {
  val noArgTest = NoArgTest::class.java.getConstructor().newInstance()
  println(noArgTest.ab)
}