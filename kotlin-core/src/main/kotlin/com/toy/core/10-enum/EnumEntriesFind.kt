package com.toy.core.`10-enum`

// values() 를 대신해서 entries 를 사용하는 것을 권장
fun main() {
    println(findByNumber(1))
}

enum class EnumEntriesFindTestEnum(val number: Int) {
    ONE(1),
    TWO(2)
}

@OptIn(ExperimentalStdlibApi::class)
fun findByNumber(number: Int): EnumEntriesFindTestEnum? = EnumEntriesFindTestEnum.entries.find { it.number == number }