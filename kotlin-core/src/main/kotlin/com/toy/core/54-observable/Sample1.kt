package com.toy.core.`54-observable`

import kotlin.properties.Delegates

data class User(var id: String, var name: String, var age: Int) {
  fun update(name: String, age: Int) {
    val observableUser = ObservableUser(this.copy())
    this.name = name
    this.age = age

    observableUser.update(this)
  }
}

class ObservableUser(initialUser: User) {
  private var user: User by Delegates.observable(initialUser) { _, oldUser, newUser ->
    val updatedUserInfo = UpdatedUserInfo()
    if (oldUser.name != newUser.name) {
      println("name updated: ${oldUser.name} -> ${newUser.name}")
      updatedUserInfo.name = newUser.name
    }

    if (oldUser.age != newUser.age) {
      println("name updated: ${oldUser.name} -> ${newUser.name}")
      updatedUserInfo.age = newUser.age
    }
  }

  fun update(user: User) {
    this.user = user
  }
}

// 갱신된 정보에 대한 push 가 필요한 경우 아래 객체를 반환받거나 observer 에서 바로 push 를 보내고 싶은데 방법이 없음.
data class UpdatedUserInfo(
  var name: String? = null,
  var age: Int? = null,
)

fun main() {
  val user = User("1", "kim", 28)
  user.update("updated", 29)
}