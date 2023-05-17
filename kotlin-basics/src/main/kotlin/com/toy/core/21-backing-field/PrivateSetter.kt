package com.toy.basic.`21-backing-field`

fun main() {
  val vo = PrivateSetterTestVO("data1", "data2")

  // vo.data1 = "change" // 직접 setter 호출 막음

  vo.change("change1", "change2")
  println(vo)
}

class PrivateSetterTestVO(
  data1: String,
  data2: String
) {

  var data1: String = data1
    private set

  var data2: String = data2
    private set

  fun change(data1: String? = null, data2: String? = null) {
    data1?.let { this.data1 = it }
    data2?.let { this.data2 = it }
  }

  override fun toString(): String {
    return "PrivateSetterTestVO(data1='$data1', data2='$data2')"
  }


}