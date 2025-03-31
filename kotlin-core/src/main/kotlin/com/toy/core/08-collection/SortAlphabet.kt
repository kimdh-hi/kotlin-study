package com.toy.core.`08-collection`

fun main() {
    println(alphabets.sortedBy { it.lowercase() })
    println(alphabets.sortedWith { alp1, alp2 -> alp1.compareTo(alp2, ignoreCase = true) }) // 대소문자 관계없이 알파벳순 정렬
    println(
        alphabets.sortedWith { a, b ->
            val lowerA = a.lowercase()
            val lowerB = b.lowercase()
            if (lowerA == lowerB) a.compareTo(b) else lowerA.compareTo(lowerB)
        }
    )
    println(
        alphabets.sortedWith(
            compareBy<String> { it.lowercase() }.thenBy { it }
        )
    )
}

private val alphabets = listOf("bbb", "BBB", "aaa", "AAA")
