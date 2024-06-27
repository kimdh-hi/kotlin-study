package com.toy.core.`66-Ip`

fun main() {
    val targetIp = "127.0.0.10"
    val startIp = "127.0.0.1"
    val endIp = "127.0.0.10"

    println(targetIp.isAllowedIp(startIp, endIp))
}

fun String.isAllowedIp(startIp: String, endIp: String? = null): Boolean {
    val convertedStartIp = startIp.toLongIp()
    val convertedEndIp = endIp?.toLongIp()
    val convertedTargetIp = this.toLongIp()

    return convertedEndIp?.let {
        convertedTargetIp in convertedStartIp..it
    } ?: (convertedTargetIp == convertedStartIp)
}

private fun String.toLongIp(): Long {
    val ipParts = this.split(".")
    require(ipParts.size == 4) { "Invalid IPv4 format: $this" }

    return ipParts.fold(0L) { acc, part ->
        (acc shl 8) + part.toLong()
    }
}