package com.toy.core.`53-serializable`

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * 단점
 * - @Serializable 를 붙여줘야 하는게 부담
 * - jackson 과 비교해서 성능성 유의미한 차이가 없다고 함 (2020 기준)
 *   https://www.ericthecoder.com/2020/11/23/benchmarking-kotlin-json-parsers-jackson-kotlin-and-kotlinx-serialization/
 * - 네이밍 전략이 default 가 camel case 임. snake case 사용하려면 @JsonName 으로 이름 지정 필요. 다른 글로벌한 설정 못 찾음
 *
 * 장점
 * - 내부적으로 reflection 을 사용하지 않음 (이로 인해 성능성 이점이 있을줄)
 * - spring 통합 가능 (KotlinSerializationJsonHttpMessageConverter 참고)
 * - jetbrain.. 유지보수 매우 잘 되는 듯 (https://github.com/Kotlin/kotlinx.serialization/releases)
 *   - 이건 jackson 라이브러리도 마찬가지임
 *
 */

fun main() {
  val innerDto = SerializableTestInnerDto("data")
  val dto = SerializableTestDto("data1", "dataCamel", listOf("listData1", "listData2"), innerDto)

  val serializedString = Json.encodeToString(dto)
  val deserializedObject = Json.decodeFromString<SerializableTestDto>(serializedString)

  println(serializedString)
  println(deserializedObject)

  val json = """
    {"data1": "data1"}
  """.trimIndent()
  val deserializedObject2 = Json.decodeFromString<DeserializableTestDto>(json)
  val deserializedObject3 = ObjectMapper().readValue(json, DeserializableTestDto::class.java)
  println(deserializedObject2)
  println(deserializedObject3)
}

@Serializable
data class SerializableTestDto(
  val data1: String,

  @SerialName("data_camel")
  val dataCamel: String,

  val list: List<String>,
  val inner: SerializableTestInnerDto
)

@Serializable
data class SerializableTestInnerDto(
  val data: String
)

@Serializable
data class DeserializableTestDto(
  val data1: String = "",
  val data2: String = "default"
)