## Any - Unit - Nothing

Any
- Java 의 Object 타입처럼 모든 객체의 조상이 되는 타입
- 실제 java 코드로 디컴파일시 Any 는 Object 타입으로 변환됨

Unit
- Java 의 void 와 같은 역할
- Java 의 void 는 단지 키워드인 반면 Kotlin 의 Unit 은 타입이다.
  - Unit 은 싱글턴 인스턴스(`object Unit`) 로 되어 있다.
  - 타입이므로 Unit 역시 Any 의 서브타입이다.

### Nothing
```kotlin
public class Nothing private constructor()
```

- `private constructor` 를 가지므로 인스턴스를 생성할 수 없다.

Nothing 이 반환타입으로 사용되는 경우
- 리턴될 일이 없는 경우에 사용된다.
  - Unit 은 값이 없음을 리턴한다.
  - Nothing 의 경우 리턴이라는 행위 자체를 하지 않는 것을 의미한다.
  - 예외만 던져지는 경우에도 반환타입으로 Nothing 이 사용된다. 

Nothing?
- null 을 리턴하거나, 리턴하지 않거나, 예외를 발생시키는 경우에 해당한다.
- 리턴하지 않거나, null을 리턴하거나..??
- 아래 억지스러운 예제의 경우 `Nothing?` 타입이 사용될 수 있다.

```kotlin
fun main() {
  val result = NothingSampleFunction(true)
}

private fun NothingSampleFunction(exception: Boolean): Nothing? {
  return if (exception) {
    throw IllegalArgumentException("exception...")
  } else {
    null
  }
}
```
- 사용할 일은 없을 듯 하다.
