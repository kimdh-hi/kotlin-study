package com.toy.core.`50-generic`.sample5

interface Sample5Interface {
  fun logic()
}

interface Sample5Interface2 {
  fun logic2()
}

// Sample5Interface 타입의 파라미터가 들어오는 것으로 제약조건 설정
// Sample5Interface 의 멤버함수 사용 가능
private fun <T: Sample5Interface> someFunction(arg: T) {
  arg.logic()
}

//두 개 이상의 제약조건을 설정하는 경우 where T: XXX, T: XXX 사용
private fun <T> someFunction2(arg: T) where T: Sample5Interface, T: Sample5Interface2 {
  arg.logic()
  arg.logic2()
}