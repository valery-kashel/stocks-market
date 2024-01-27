package com.vkashel.domain.usecases

import com.vkashel.domain.models.User

interface CreateNewUserUseCase {
    fun createUser(
        email: String,
        username: String,
        password: String,
    ): User
}