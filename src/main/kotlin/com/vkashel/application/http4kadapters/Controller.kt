package com.vkashel.application.http4kadapters

import org.http4k.core.HttpHandler

interface Controller {
    fun contractRoutes() : HttpHandler
}