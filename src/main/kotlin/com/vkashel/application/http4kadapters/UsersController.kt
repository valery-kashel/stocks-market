package com.vkashel.application.http4kadapters

import com.vkashel.application.ports.UsersPort
import com.vkashel.application.requests.CreateNewUserRequest
import com.vkashel.application.responses.CreateNewUserResponse
import com.vkashel.domain.services.UserService
import com.vkashel.utils.passwordencoder.PasswordEncoder
import org.http4k.core.Body
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.with
import org.http4k.format.Jackson.auto
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes

private val createNewUserRequestLens = Body.auto<CreateNewUserRequest>().toLens()
private val createNewUserResponseLens = Body.auto<CreateNewUserResponse>().toLens()

class UsersController(
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder,
) : UsersPort, Controller {

    override fun contractRoutes(): RoutingHttpHandler = routes(
        "users" bind Method.POST to ::createNewUserFun
    )

    override fun createNewUser(request: CreateNewUserRequest): CreateNewUserResponse {
        val createdUser = with(request) {
            userService.createUser(
                email =email,
                username = username,
                password = passwordEncoder.encode(password),
            )
        }
        return CreateNewUserResponse(
            id = createdUser.id.toString(),
            email = createdUser.email,
            username = createdUser.username,
        )
    }

    private fun createNewUserFun(request: Request): Response {
        val createNewUserRequest = createNewUserRequestLens(request)
        val response = createNewUser(createNewUserRequest)
        return Response(Status.CREATED).with(createNewUserResponseLens of response)
    }
}