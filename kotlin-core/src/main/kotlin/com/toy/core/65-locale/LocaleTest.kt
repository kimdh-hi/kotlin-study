package com.toy.core.`65-locale`

import java.util.Locale

fun main() {
    val locale1 = Locale("en")
    val locale2 = Locale.Builder().setLanguage("en").build()
    val locale3 = Locale.forLanguageTag("en")

    println(locale1)
    println(locale2)
    println(locale3)

    println(locale1.language)
    println(locale2.language)
    println(locale3.language)
}