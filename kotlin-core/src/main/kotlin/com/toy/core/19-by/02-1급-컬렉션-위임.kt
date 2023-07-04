package com.toy.core.`19-by`

/**
 * 1급 컬렉션 사용시 by 를 이용한 public api 위임
 *
 */

data class SomeData(
    val data: String
)

// 1급 컬렉션 내 실제 컬렉션 대상 연산을 하고 싶은 경우 ex) someDataList.contains(...)
class SomeDataList(datas: List<SomeData>): List<SomeData> by datas {
    // by 를 사용하지 않은 경우 List 의 public api 를 사용하려면 하나하나 구현해줘야 함 (근데 구현은 대부분 bypass..)
}

fun main() {
    val someData = SomeData("a")
    val result = SomeDataList(listOf(SomeData("a"))).contains(someData) // by를 통한 위임 전 사용불가

    println(result)
}
