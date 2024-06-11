package com.toy.core.kotlin_2_0

class SomeClass(private val provider: (() -> Unit)? = null) {

    fun logic() {
        if (provider != null) {
            provider.invoke()
        }
    }
}

fun main() {
    SomeClass { println("asd") }.logic()
    SomeClass().logic()
}