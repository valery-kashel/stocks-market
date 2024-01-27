package com.vkashel

import com.vkashel.infrastructure.configuration.ServerConfiguration
import com.vkashel.infrastructure.configuration.http4k.Http4KServerConfiguration

fun main() {
    val configuration: ServerConfiguration = Http4KServerConfiguration()
    configuration.start()
}
