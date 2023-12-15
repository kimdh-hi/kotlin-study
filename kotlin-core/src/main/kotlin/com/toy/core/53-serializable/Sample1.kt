package com.toy.core.`53-serializable`

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun main() {
  val innerDto = SerializableTestInnerDto("data")
  val dto = SerializableTestDto("data1", listOf("listData1", "listData2"), innerDto)

  val serializedString = Json.encodeToString(dto)
  val deserializedObject = Json.decodeFromString<SerializableTestDto>(serializedString)

  println(serializedString)
  println(deserializedObject)
}

@Serializable
data class SerializableTestDto(
  val data1: String,
  val list: List<String>,
  val inner: SerializableTestInnerDto
)

@Serializable
data class SerializableTestInnerDto(
  val data: String
)