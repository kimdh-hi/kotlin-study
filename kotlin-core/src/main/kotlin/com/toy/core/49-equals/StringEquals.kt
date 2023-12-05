package com.toy.core.`49-equals`

fun main() {
  val a = "a"
  val b = "b"
  println(a == b)

  val aa = "aa"
  val bb: String? = null
  println(aa == bb)

  // java 에서 문자열 비교시 StringUtils.equals(a, b) 를 많이 사용
  // 문자열 비교로 어떤 방식이 좋은지 성능을 따지는건 큰 의미가 없을 듯
  // java 에서 StringUtils.equals(a, b) 를 사용한 가장 큰 이유는 NPE 를 피하기 위함임

  // kotlin 에서는 NPE 발생하지 않음 (stirng == 연산은 아래 자바 코드로 컴파일 됨)
  /**
   *     public static boolean areEqual(Object first, Object second) {
   *         return first == null ? second == null : first.equals(second);
   *     }
   */

  // 결론, kotlin 에서는 그냥 == 쓰자..

  // kotlin string == 연산자는 대소문자를 구분함
  // 대소문자 ignore가 피료하다면 cc.equals(CC, ignoreCase = true) 사용
  val cc = "cc"
  val CC = "CC"
  println(cc == CC)
  println(cc.equals(CC, ignoreCase = true))
}