package com.toy.core.`33-const_value`

/**
 * private const val vs companion object private const val
 *
 * - private const val (top level) 는 동일 파일 내 여러 클래스에서 사용가능
 * - top level 을 사용하는 경우 외부에 접근시 상수명을 정확히 알아야 함
 *   - SOME_CONST_VALUE1
 *   - PERSON.SOME_CONST_VALUE2
 *
 * private const val 처럼 private 을 사용한다면 코드양? 측면에서 top-level 도 좋은듯
 * 만약 companion object 를 사용중이지 않은 클래스라면 top-level 에 상수 정의해보자.
 */

private const val SOME_CONST_VALUE1 = "aaa"

data class Person(
  val name: String
) {

  companion object {
    private const val SOME_CONST_VALUE2 = "bbb"
  }
}