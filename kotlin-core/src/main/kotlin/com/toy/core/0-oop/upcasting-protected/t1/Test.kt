package com.toy.core.`0-oop`.`upcasting-protected`.t1

import com.toy.core.`0-oop`.`upcasting-protected`.t2.Child1

class Test {

  fun test() {
    val parent1: Parent1 = Child1()
//    parent1.func()
    // 업케스팅 시 부모 클래스와 같은 패키지에서 protected 메서드 호출시 컴파일 에러; (동일 구조의 코드 java 는 허용;;)

  // java 코드 디컴파일시
  // Parent1 parent1 = (Parent1)(new Child1());
  }
}