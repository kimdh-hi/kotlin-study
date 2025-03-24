package com.toy.core.`67-file`

import java.io.File
import java.net.URI
import java.nio.file.Paths

fun main() {
  val sourceUrl = "https://github.githubassets.com/assets/home24-5939032587c9.jpg?param=100"
  val file = getFileFromUrl(sourceUrl)

  println(file.path)
}

// queryString ignored.
private fun getFileFromUrl(url: String): File {
  val path = URI.create(url).path.takeIf { it.isNotEmpty() }
    ?: throw IllegalArgumentException("Path not found from url: $url")

  return Paths.get(path).toFile()
}
