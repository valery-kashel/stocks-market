package com.vkashel.domain.models

import java.util.UUID

data class User(
    val id: String,
    val email: String,
    val role: Roles,
    val username: String,
    val password: String,
) {
    companion object {
        fun createNew(
            email: String,
            username: String,
            password: String,
            role: Roles = Roles.USER,
        ): User =
            User(
                id = UUID.randomUUID().toString(),
                email = email,
                username = username,
                password = password,
                role = role,
            )
    }
}

enum class Roles {
    ADMIN,
    USER,
}
