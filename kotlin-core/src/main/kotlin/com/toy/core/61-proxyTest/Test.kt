package com.toy.core.`61-proxyTest`

open class Origin(private val data: String? = null) {
  open fun execute(): String? {
    return data
  }

  fun execute2(): String? {
    return data
  }
}

class ProxyOrigin(private val origin: Origin): Origin() {

  override fun execute(): String? {
    return origin.execute()
  }
}

fun main() {
  val origin = Origin("data")
  val proxyOrigin = ProxyOrigin(origin)
  println(proxyOrigin.execute())
  println(proxyOrigin.execute2()) // : Origin() 기본생성자, 즉 data=null 로 생성된 origin 의 execute2 메서드가 호출
}