package com.toy.core.`58-visiblity`

open class ParentSample {
  protected fun aaa() {
    println("hi")
  }

  fun bbb() {
    aaa()
  }
}

class ChildSample: ParentSample() {
  fun ccc() {
    aaa()
  }
}

