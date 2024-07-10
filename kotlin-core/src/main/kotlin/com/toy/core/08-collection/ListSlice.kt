package com.toy.core.`08-collection`

fun main() {
    val list = mutableListOf(1, 2, 3, 4, 5)
    val subList = list.subList(0, 3) //1,2,3
    val sliceList = list.slice(0..2) //1,2,3
    println(subList)
    println(sliceList)

    list[1] = 10

    println(subList) //1,10,3 /** subList 원본 list 의 영향을 받음 **/
    println(sliceList) //1,2,3

    val list2 = mutableListOf(1, 2, 3, 4, 5)
    val takeList = list2.take(3) //1,2,3
    val dropList = list2.drop(3) //4,5
    println(takeList)
    println(dropList)
    list2[0] = 10
    println(takeList) // 원본 리스트 영향 x
    println(dropList)

    val outOfRangeTakeList = takeList.take(10)
    println(outOfRangeTakeList) // outOfRangeException 발생x (drop 동일)
}