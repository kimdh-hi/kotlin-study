package com.toy.core.`28-let`

inline fun <T1 : Any, T2 : Any, R : Any> let2(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
  return if (p1 != null && p2 != null) block(p1, p2) else null
}

inline fun <T: Any, R: Any> letMulti(vararg args: T?, block: (List<T>) -> R): R? {
  return if (args.all { it != null }) {
    block(args.filterNotNull())
  } else null
}

fun main() {
  val data1: String? = "aaa"
  val data2: String? = "bbb"

  data1?.let { d1 ->
    data2?.let { d2 ->
      println("$d1, $d2")
    }
  }

  if (data1 != null && data2 != null) {
    println("$data1, $data2")
  }

  let2(data1, data2) { d1, d2 ->
    println("$d1, $d2")
  }

  val data3: String? = "ccc"
  letMulti(data1, data2, data3) {
    println(it)
  }
}


//https://www.baeldung.com/kotlin/multiple-variables-let