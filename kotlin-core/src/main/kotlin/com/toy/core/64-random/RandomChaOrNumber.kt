package com.toy.core.`64-random`

private val POOL = ('A'..'Z') + ('a'..'z') + ('0'..'9')

private fun generate(wordCount: Int) = (0 until wordCount)
        .map { POOL.random() }
        .joinToString("")


fun main() {
    println(generate(10))
}
