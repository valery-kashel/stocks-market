package com.vkashel.application.ports

import com.vkashel.application.requests.CreateNewUserRequest
import com.vkashel.application.responses.CreateNewUserResponse

interface UsersPort {
    fun createNewUser(request: CreateNewUserRequest): CreateNewUserResponse
}
