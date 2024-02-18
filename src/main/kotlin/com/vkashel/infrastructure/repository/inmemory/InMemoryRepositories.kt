package com.vkashel.infrastructure.repository.inmemory

import com.vkashel.domain.ports.UsersRepository
import com.vkashel.infrastructure.configuration.Repositories

class InMemoryRepositories : Repositories {
    override val usersRepository: UsersRepository = UsersInMemoryRepository()
}
