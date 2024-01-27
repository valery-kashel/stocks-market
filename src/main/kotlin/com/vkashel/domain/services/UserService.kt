package com.vkashel.domain.services

import com.vkashel.domain.models.User
import com.vkashel.domain.ports.UsersRepository
import com.vkashel.domain.usecases.CreateNewUserUseCase

class UserService(
    private val usersRepository: UsersRepository,
) : CreateNewUserUseCase {
    override fun createUser(
        email: String,
        username: String,
        password: String,
    ): User {
        val user =
            User.createNew(
                email = email,
                username = username,
                password = password,
            )
        return usersRepository.save(user)
    }
}
