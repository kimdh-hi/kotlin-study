## RxJava

### Cold Publisher & Hot Publisher

Cold Publisher
- producer 는 consumer 가 구독할 때마다 데이터를 처음부터 새로 통지한다.
- consumer 는 구독 시점에 관계없이 통지된 데이터를 처음부터 전달받을 수 있다.

Hot Publisher
- consumer 의 수에 관계없이 데이터를 한 번만 통지한다.
- 즉, consumer 는 구독한 시점부터 통지된 데이터들만 받을 수 있다.