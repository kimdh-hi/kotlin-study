## RxJava

### Cold Publisher & Hot Publisher

Cold Publisher
- producer 는 consumer 가 구독할 때마다 데이터를 처음부터 새로 통지한다.
- consumer 는 구독 시점에 관계없이 통지된 데이터를 처음부터 전달받을 수 있다.

Hot Publisher
- consumer 의 수에 관계없이 데이터를 한 번만 통지한다.
- 즉, consumer 는 구독한 시점부터 통지된 데이터들만 받을 수 있다.

---

### Flowable, Observable

Flowable
- `Subscriber` 에서 데이터 처리
- 배압 기능 제공 (데이터 개수 제어)
  - 배압: 구독을 통해 전달받는 데이터의 개수를 제어

Observable
- `Observer` 에서 데이터 처리
- 배압 기능 없음

#### 배압 BackPressure
`Flowable` 에서 데이터를 발행하는 속도가 `Subscriber` 에서 발행된 데이터를 처리하는 속도보다 빠른 경우 이를 제어하는 기능이다.

배압전략
- Missing 전략
  - 배압 사용X
    - `onBackpressureXXX()` 로 배압 적용 가능
- Error 전략
  - `MissingBackpressureException` 에러 발생
- Buffer 전략 - `DROP_LATEST`
  - producer 와 consumer 사이 버퍼로 배압조절 
  - 버퍼가 가득찬 시점에서 가장 최근 버퍼로 들어온 데이터를 drop 한다.
  - drop 되어 생긴 빈 자리는 밖에서 대기하 데이터로 채운다.
- Buffer 전략 - `DROP_OLDEST`
  - 버퍼가 가득찬 시점에서 버퍼 내 가장 오래된(가장 먼저 들어온) 데이터를 drop 한다.
- Buffer 전략 - `Drop`
  - 버퍼가 가득차면 이후 통지되는 모든 데이터는 drop, 버퍼가 비워지는 시점부터 통지되는 데이터를 버퍼에 담는다.
- Buffer 전략 - `LATEST`
  - 버퍼가 가득차면 버퍼가 비워질 때까지 버퍼 밖에서 대기하고 버퍼가 비워질 때 가장 최근 통지된 데이터부터 버퍼에 담는다. 