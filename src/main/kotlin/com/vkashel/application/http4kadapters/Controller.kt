package com.vkashel.application.http4kadapters

import org.http4k.routing.RoutingHttpHandler

interface Controller {
    fun contractRoutes(): RoutingHttpHandler
}
