package com.vkashel.infrastructure.repository

import com.vkashel.domain.models.User
import com.vkashel.domain.ports.UsersRepository
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

class UsersInMemoryRepository : UsersRepository {
    private val storage = ConcurrentHashMap<UUID, User>()

    override fun save(user: User): User {
        storage[user.id] = user
        return user
    }
}