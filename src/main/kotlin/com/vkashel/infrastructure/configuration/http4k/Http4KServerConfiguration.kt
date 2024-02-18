package com.vkashel.infrastructure.configuration.http4k

import com.vkashel.application.http4kadapters.UsersController
import com.vkashel.domain.services.UserService
import com.vkashel.infrastructure.configuration.ServerConfiguration
import com.vkashel.infrastructure.repository.database.DatabaseRepositories
import com.vkashel.utils.passwordencoder.Base64PasswordEncoder
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters
import org.http4k.routing.routes
import org.http4k.server.Undertow
import org.http4k.server.asServer

class Http4KServerConfiguration : ServerConfiguration {
    override fun start() {
        val passwordEncoder = Base64PasswordEncoder()
        val repositories = DatabaseRepositories()

        val usersRepository = repositories.usersRepository

        val userService =
            UserService(
                usersRepository = usersRepository,
            )

        val usersController =
            UsersController(
                userService = userService,
                passwordEncoder = passwordEncoder,
            )

        val routes =
            routes(
                usersController.contractRoutes(),
            )

        val server =
            DebuggingFilters.PrintRequest()
                .then(routes)
                .asServer(Undertow())
                .start()

        println("server started on: ${server.port()}")
    }
}
