package com.toy.core.`36-dsl`

/**
 * gradle, spring security, junit 등 많은 곳에서 kotlin dsl 이 적용되고 있음
 * 실제 kotlin dsl 을 적용해볼만한 부분은 아래와 같은 builder 를 구성할 때가 있음
 *
 * createMember {
 *   name("김대현")
 *   age(28)
 *   job("??")
 * }
 */
fun main() {
    val member = createMember {
        name("김대현")
        age(28)
        job("developer")
    }

    println(member)
}

// block: PersonBuilder() -> Unit
// 익명함수로 PersonBuilder 의 멤버함수를 강제
fun createMember(block: MemberBuilder.() -> Unit): Member {
    return MemberBuilder().apply(block).build()
}

data class Member(val name: String, val age: Int, val job: String?)

class MemberBuilder {
    private lateinit var name: String
    private var age: Int = 0
    private var job: String? = null

    fun name(name: String) {
        this.name = name
    }

    fun age(age: Int) {
        this.age = age
    }

    fun job(job: String?) {
        this.job = job
    }

    fun build(): Member {
        return Member(name, age, job)
    }
}