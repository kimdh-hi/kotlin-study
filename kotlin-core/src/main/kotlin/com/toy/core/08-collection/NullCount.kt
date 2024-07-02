package com.toy.core.`08-collection`

fun main() {
    println(listOf("aa", 1, null, null).count { it != null} )
}