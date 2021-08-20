package org.example.mirai.plugin

import io.ktor.http.*
import java.time.ZoneId
import java.util.*

enum class ServerType(val locale: Locale, val zone: ZoneId) {
    CN(Locale.CHINA, ZoneId.of("GMT+08:00")),
}

var SERVER: ServerType = ServerType.CN

interface GameDataType {
    val path: String
    val url: Url
    val duration: Long get() = 0
}