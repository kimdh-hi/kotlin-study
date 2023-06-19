package com.toy.core.`34-value-class`

/**
 * value class 는 인스턴스 자체를 만들지 않는다. (디컴파일 필요)
 * 원시값 wrapping 시 인스턴스 생성으로 힙 메모리를 차지하는 문제 해결을 위함 (객체 생성비용 절감)
 *
 * https://kotlinlang.org/docs/inline-classes.html
 *
 * - 프로퍼티로는 val 만 허용한다.
 * - 하나의 프로퍼티을 가질 수 있다.
 */

@JvmInline
value class Number(private val number: Int)

fun main() {
    val number1 = Number(1)
    val number2 = Number(1)
    println(number1 == number2) // true
}