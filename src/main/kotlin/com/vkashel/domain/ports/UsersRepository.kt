package com.vkashel.domain.ports

import com.vkashel.domain.models.User

interface UsersRepository {
    fun save(user: User): User
}