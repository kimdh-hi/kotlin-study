package com.toy.core.`29-JVM signature error`

//Platform declaration clash: The following declarations have the same JVM signature
//constructor JvmSignatureErrorTest(data1: String, dataList: List<JvmSignatureErrorTest2>)
//constructor JvmSignatureErrorTest(data1: String, dataList: List<String>)

//byte 코드 변환시 List<JvmSignatureErrorTest2> 과 List<String> 를 구분할 수 없음.
//컴파일 시 파라미터 타입으로 생성자를 구분하게 되는데 이 때 generic 타입은 구분하지 못함.
//List<JvmSignatureErrorTest2> => List<T>
//List<String> => List<T>

//사용하지 않는 임의 필드를 추가해서 생성자가 파라미터로 구분되도록
fun main() {
  val result = JvmSignatureErrorTest("data", listOf("data1", "data2"))
  println(result)
}

data class JvmSignatureErrorTest(
  val data1: String,
  val dataList: List<JvmSignatureErrorTest2>,
  val dummyImplicit: Any? = null // 생성자 충돌방지를 위한 필드
) {
  constructor(data1: String, dataList: List<String>): this(data1, dataList.map { JvmSignatureErrorTest2.of(it) })
}

data class JvmSignatureErrorTest2(
  val data: String
) {
  companion object {
    fun of(data: String) = JvmSignatureErrorTest2(data)
  }
}