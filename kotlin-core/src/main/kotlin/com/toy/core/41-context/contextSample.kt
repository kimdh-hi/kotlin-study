package com.toy.core.`41-context`

class Logger(val name: String) {
  fun log(s: String) = println("[log] name: $s")

  fun log2(s: String) = println("[log2] name: $s")

}

class NotificationSender(val name: String){
  fun send(s: String) = println("notification send: $s")
}

interface LoggerContext {
  val logger: Logger
}

interface NotificationSenderContext {
  val notificationSender: NotificationSender
}

//freeCompilerArgs = listOf("-Xcontext-receivers")
//context(Logger, NotificationSender)
context(LoggerContext, NotificationSenderContext)
fun store(s: String) {
  logger.log("store.. $s")
  logger.log2("store.. $s")

  //context 를 사용해서 리시버 타입의 함수를 사용하는 경우 파라미터가 겹차는 경우 사용
//  send("send.. $s (via.. name: ${this@NotificationSender.name})")
//  send("send.. $s (via.. name: $name)") // Logger 의 name, NotificationSender 의 name (파라미터 모호성으로 인한 컴파일 에러 발생)
  notificationSender.send("send.. $s (via.. name: ${notificationSender.name})")
}

//fun Logger.store(s: String) {
//  log("store.. $s")
//}

fun main() {
  val logger = Logger("main")
  val notificationSender = NotificationSender("kim")
//  store("test1", logger)
//  store("test2", logger)
//  store("test3", logger)

  val loggerContext = object: LoggerContext {
    override val logger = logger
  }

  val notificationSenderContext = object : NotificationSenderContext {
    override val notificationSender = notificationSender
  }

  with(loggerContext) {
    with(notificationSenderContext) {
      store("test1")
      store("test2")
      store("test3")
    }
  }
}
