package com.toy.basic.`19-by`

interface TestInterface {
  fun execute(message: String)
}

class TestClassA: TestInterface {
  override fun execute(message: String) {
    println("execute by A message: $message")
  }
}

class TestClassB: TestInterface {
  override fun execute(message: String) {
    println("execute by B message: $message")
  }
}

class TestClassC: TestInterface {
  override fun execute(message: String) {
    println("execute by C message: $message")
  }
}

// 보통의 delegator pattern
class TestDelegatorV1(
  private val target: TestInterface
) {
  fun execute(message: String) {
    target.execute(message)
  }

  fun executeOthers() {
    println("executeOthers..")
  }
}

// by 를 이용한 delegator pattern (클래스 위임)
class TestDelegatorV2(
  private val target: TestInterface
): TestInterface by target {

  fun executeOthers() {
    println("executeOthers..")
  }
}

fun main() {
  val classA = TestClassA()

  val delegatorV1 = TestDelegatorV1(classA)
  delegatorV1.execute("test")
  delegatorV1.executeOthers()

  val delegatorV2 = TestDelegatorV2(classA)
  delegatorV2.execute("test")
  delegatorV2.executeOthers()

}
