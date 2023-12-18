package com.toy.core.`54-observable`

import kotlin.properties.Delegates

data class User(var id: String, var name: String) {
  fun update(name: String) {
    val observableUser = ObservableUser(this.copy())
    this.name = name

    observableUser.update(this)
  }
}

class ObservableUser(initialUser: User) {
  private var user: User by Delegates.observable(initialUser) { _, oldUser, newUser ->
    if (oldUser.name != newUser.name)
      println("name 변경: ${oldUser.name} -> ${newUser.name}")
  }

  fun update(user: User) {
    this.user = user
  }
}

fun main() {
  val user = User("1", "kim")
  user.update("updated")
}