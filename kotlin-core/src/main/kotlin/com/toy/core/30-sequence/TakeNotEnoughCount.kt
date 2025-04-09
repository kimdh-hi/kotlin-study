package com.toy.core.`30-sequence`

import kotlin.time.measureTime


// sequence 사용시 연산자체는 지연평가 되기 때문에 많은 데이터 생성 및 가공시 성능상 이점이 있을 수 있음.
// 아래 코드처럼 take 와 filter, takeWhile 등 사용시 take 의 수만큼 가져올 데이터가 없는 경우 take(n) 의 부족한 수만큼 무한 sequence 가 생성됨. (오버플로우 발생)
// 무한 sequence, take, filter 등 사용시 주의 필요
// result: [1, 2, 3, 4, 5, 6, 7, 8, 9, -2147483648, -2147483647, -2147483646, -2147483645, -2147483644, -2147483643]
// measureTime: 11s

// 필요한 경우 (1..n) 으로 범위 제한 후 .asSequence 사용

private const val MAX_COUNT = 9999
private const val TAKE_COUNT = 10
fun main() {

//  val infinitySequenceMeasureTime = measureTime {
//    val list = generateSequence(1) { it + 1 }
//      .filter { it < 10 }
//      .take(15)
//      .takeWhile { it < MAX_COUNT }
//      .toList()
//
//    println(list)
//  }

  val iterableMeasureTime = measureTime {
    val list = (1..MAX_COUNT)
      .filter { it < 10 }
      .take(15)
      .takeWhile { it < TAKE_COUNT }
      .toList()

    println(list)
  }

  val rangeSequenceMeasureTime = measureTime {
    val list = (1..MAX_COUNT)
      .asSequence()
      .filter { it < 10 }
      .take(TAKE_COUNT)
      .toList()

    println(list)
  }


//  println(infinitySequenceMeasureTime.inWholeMicroseconds)
  println(iterableMeasureTime.inWholeMilliseconds)
  println(rangeSequenceMeasureTime.inWholeMilliseconds)
}
