package com.toy.core.`02-scope-function`

data class AA(
  val data1: String,
  val data2: String,
)

data class BB(
  val data1: String,
  val data2: String,
  val data3: String,
) {
  companion object {
    //unit return
//    fun of(aa: AA, data3: String) {
//      return with(aa) {
//        BB(
//          data1 = data1,
//          data2 = data2,
//          data3 = data3
//        )
//      }
//    }

    // return type 명시시 BB 타입 리턴
    fun of(aa: AA, data3: String): BB {
      return with(aa) {
        BB(
          data1 = data1,
          data2 = data2,
          data3 = data3
        )
      }
    }

    // expression 으로 선언시에도 BB 타입 반환 (정상동작)
//    fun of(aa: AA, data3: String) = with(aa) {
//      BB(
//        data1 = data1,
//        data2 = data2,
//        data3 = data3
//      )
//    }
  }
}

fun main() {
  val aa = AA("data1", "data2")
  val bb = BB.of(aa, "data3")
  println(bb)
}
