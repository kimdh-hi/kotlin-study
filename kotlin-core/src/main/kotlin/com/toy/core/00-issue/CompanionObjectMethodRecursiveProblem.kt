package com.toy.core.`00-issue`

data class ParentDto(
  val data: String,
  val children: List<ParentDto>
) {

  companion object {
    //재귀호출시 반환타입 명시 필요
    //compile error
//    fun of(parentEntity: ParentEntity) = ParentDto(data = parentEntity.data, children = parentEntity.children.map { of(it) })

    fun of(parentEntity: ParentEntity): ParentDto = ParentDto(data = parentEntity.data, children = parentEntity.children.map { of(it) })
  }
}

data class ParentEntity(
  val data: String,
  val children: List<ParentEntity>
)