### 고차 함수
- 인자 혹은 반환값으로 람다를 사용하는 경우


### inline function
- 람다는 해당 람다 함수의 인자 수만큼 `FunctionN` 으로 컴파일 타임에 변환 된다.
```kotlin
fun some(a: Int, b: Int, (x, y) -> )
```