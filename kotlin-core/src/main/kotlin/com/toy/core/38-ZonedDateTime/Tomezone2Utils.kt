import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.util.*

private val AVAILABLE_TIMEZONE_REGEX = Regex("^(Africa|America|Asia|Atlantic|Australia|Europe|Indian|Pacific)/.*")

object Timezone2Utils {

  private var availableTimeZoneVOs: List<TimezoneVO>

  init {
    availableTimeZoneVOs = generateTimezones()
  }

  fun getTimezoneList(myTimeZone: TimeZone): List<TimezoneVO> {
    availableTimeZoneVOs.first { it.timezone == myTimeZone.id }
      .current = true

    return availableTimeZoneVOs
  }

  private fun generateTimezones(): List<TimezoneVO> {
    val timezoneVOs = mutableListOf<TimezoneVO>()
    TimeZone.getAvailableIDs().map { timeZoneId ->
      val timezone = TimeZone.getTimeZone(timeZoneId)
      if (timeZoneId.matches(AVAILABLE_TIMEZONE_REGEX)) {
        timezoneVOs.add(TimezoneVO.of(timezone))
      }
    }

    return timezoneVOs.sortedBy { it.offset }.toList()
  }

  fun adjustTimezone(date: LocalDateTime, zoneId: ZoneId): LocalDateTime {
    val zonedDateTime = ZonedDateTime.of(date, ZoneOffset.UTC)
    return zonedDateTime.withZoneSameInstant(zoneId).toLocalDateTime()
  }
}

data class TimezoneVO(
  val timezone: String,
  val offset: Int,
  var current: Boolean = false
) {
  companion object {
    fun of(timezone: TimeZone) = TimezoneVO(
      timezone = timezone.id,
      offset = timezone.rawOffset / (60 * 60 * 1000)
    )
  }
}

fun main() {
  val result = Timezone2Utils.getTimezoneList(TimeZone.getDefault())
  println(result)
}