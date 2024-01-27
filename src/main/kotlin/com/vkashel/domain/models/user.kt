package com.vkashel.domain.models

import java.util.UUID

data class User(
    val id: UUID,
    val email: String,
    val username: String,
    val password: String,
) {
    companion object {
        fun createNew(
            email: String,
            username: String,
            password: String
        ): User = User(
            id = UUID.randomUUID(),
            email = email,
            username = username,
            password = password,
        )
    }
}