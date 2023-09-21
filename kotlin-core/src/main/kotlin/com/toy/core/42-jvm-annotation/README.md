JVM annotation

kotlin -> java 바이트 코드 변환시 정밀한 제어를 위해 사용 <br/>

- `@JvmName`
- `@JvmStatic`
- `@JvmField`
- `@JvmDefault`
- `@JvmOverloads`
- `@Throws`
- `@JvmWildcard`
- `@JvmSuppressWildcards`
- `@JvmMultifileClass`
- `@JvmPackageName`

### @JvmName
- 지정 가능: `파일`, `함수`, `프로퍼티(getter/setter)`

#### @JvmName - 파일
- @JvmName 지정하지 않은 경우 해당 파일명이 `Test` 라면 `TestKt` 로 class 생성 후 static 메서드로 getTest 를 포함시킨다.
- 자바코드로 변환됐을 때 `TestKt` 가 아닌 `Test` 로 하고 싶다면 `@JvmName` 으로 대상 클래스명을 지정한다.
```kotlin
package com.core

fun getTest() : String {
  return "test"
}

// 아래는 실제 사용
val test = getTest()
```

- 자바코드 변환시 `Test` 를 클래스 이름으로 사용
```kotlin
@file:JvmName("Test")
package com.core

fun getTest() : String {
    return "test"
}

// 아래는 실제 사용
val test = getTest()
```

#### @JvmName - 함수

`case1` - getter 이름 중복
```kotlin
class Test {
  val name: String = ""
  
  fun getName() = name // 프로퍼티의 getter 와 중복되므로 컴파일 타임에 Platform declaration clash: The following declarations have the same JVM signature 발생
  
  @JvmName("getNameV2")
  fun getName() = name
}
```

`case2` - 제네릭 타입 (Type Erasure)
- 컴파일 시 제네렉 타입은 사라진다.
- 제네릭 타입을 인자로 받는 함수를 오버로딩하는 경우 제네릭 타입 외 모든 인자가 같다면 컴파일 에러를 발생시킨다.
```kotlin
class Test {
  private var list: List<Long> = emptyList()
  
  fun setToList(list: List<Int>) {
    this.list = list.map { it.toLong }.toList()
  }

  fun setToList(list: List<String>) {
    this.list = list.map { it.toLong }.toList()
  }
}
```

- @JvmName 을 지정해서 오버로딩이지만 컴파일 타임에 함수의 이름이 서로 달라질 수 있도록 해서 애러를 방지한다.
```kotlin
class Test {
  private var list: List<Long> = emptyList()
  
  @JvmName("setToListByInt")
  fun setToList(list: List<Int>) {
    this.list = list.map { it.toLong }.toList()
  }

  @JvmName("setToListByString")
  fun setToList(list: List<String>) {
    this.list = list.map { it.toLong }.toList()
  }
}
```
