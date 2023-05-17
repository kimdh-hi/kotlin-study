package com.toy.core.`27-reduce-fold`

fun main() {
  val user1 = ReduceSampleUser(age = 30)
  val user2 = ReduceSampleUser(age = 28)
  val user3 = ReduceSampleUser(age = 40)

  val users = listOf(user1, user2, user3)

  val maxAgeUser = users
    .reduce { user1, user2 -> if (user1.age > user2.age) user1 else user2 }
  println(maxAgeUser)

  val minAgeUser = users
    .reduce { user1, user2 -> if (user1.age < user2.age) user1 else user2  }
  println(minAgeUser)
}

data class ReduceSampleUser(
  val age: Int
)