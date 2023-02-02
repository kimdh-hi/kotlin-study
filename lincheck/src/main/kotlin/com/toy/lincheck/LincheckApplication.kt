package com.toy.lincheck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LincheckApplication

fun main(args: Array<String>) {
  runApplication<LincheckApplication>(*args)
}
