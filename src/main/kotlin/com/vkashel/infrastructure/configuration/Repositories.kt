package com.vkashel.infrastructure.configuration

import com.vkashel.domain.ports.UsersRepository

interface Repositories {
    val usersRepository: UsersRepository
}
