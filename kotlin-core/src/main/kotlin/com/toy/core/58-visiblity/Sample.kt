package com.toy.core.`58-visiblity`

open class ParentSample {
  protected fun aaa() {
    println("hi")
  }

  fun bbb() {
    aaa()
    privateFunc()
  }
}

class ChildSample(
  val protectedSampleClass: ProtectedSampleClass
): ParentSample() {
  fun ccc() {
    aaa()
    protectedSampleClass.publicFunc()
  }
}

class OuterClass {
  inner class InnerClass {
    private fun func() { }
  }

  fun func() {
    //InnerClass().func() // 내부 클래스 private 접근 불가
  }
}

private fun privateFunc() { }

