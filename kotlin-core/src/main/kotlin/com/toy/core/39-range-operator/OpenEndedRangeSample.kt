package com.toy.core.`39-range-operator`

// kotlin 1.9.0 stable ..<
// until 보다는 괜찮은 느낌

// 디컴파일 결과
//   [..<] 는 while 로 변환
//   [until] 은 for 문으로 변환
// 의미 없을듯
fun main() {

  for (number in 1 ..< 10) {
    print("$number ")
  }

  println("\n=============")

  for (number in 1 until 10) {
    print("$number ")
  }
}