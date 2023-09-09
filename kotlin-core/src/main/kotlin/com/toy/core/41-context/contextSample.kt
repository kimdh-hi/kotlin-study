package com.toy.core.`41-context`

fun main() {
  val logger = Logger("main")
  val notificationSender = NotificationSender("kim")
//  store("test1", logger)
//  store("test2", logger)
//  store("test3", logger)

  with(logger) {
    with(notificationSender) {
      store("test1")
      store("test2")
      store("test3")
    }
  }

}

class Logger(val name: String) {
  fun log(s: String) = println("[log] name: $s")

  fun log2(s: String) = println("[log2] name: $s")

}

class NotificationSender(val name: String){
  fun send(s: String) = println("notification send: $s")
}

//freeCompilerArgs = listOf("-Xcontext-receivers")
context(Logger, NotificationSender)
fun store(s: String) {
  log("store.. $s")
  log2("store.. $s")

  //context 를 사용해서 리시버 타입의 함수를 사용하는 경우 파라미터가 겹차는 경우 사용
  send("send.. $s (via.. name: ${this@NotificationSender.name})")
//  send("send.. $s (via.. name: $name)") // Logger 의 name, NotificationSender 의 name (파라미터 모호성으로 인한 컴파일 에러 발생)
}

//fun Logger.store(s: String) {
//  log("store.. $s")
//}