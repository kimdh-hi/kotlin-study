package com.toy.core.`10-enum`

// values() 를 대신해서 entries 를 사용하는 것을 권장
fun main() {
    val v0Result = EnumEntriesFindTestEnum.findByNumberV0(1)
    val v1Result = EnumEntriesFindTestEnum.findByNumber(1)

    println(v0Result)
    println(v1Result)
}

enum class EnumEntriesFindTestEnum(val number: Int) {
    ONE(1),
    TWO(2);

    companion object {
        fun findByNumberV0(number: Int) = EnumEntriesFindTestEnum.values().find { it.number == number }

        fun findByNumber(number: Int) = EnumEntriesFindTestEnum.entries.find { it.number == number }
    }
}

fun findByNumber(number: Int): EnumEntriesFindTestEnum? = EnumEntriesFindTestEnum.entries.find { it.number == number }
