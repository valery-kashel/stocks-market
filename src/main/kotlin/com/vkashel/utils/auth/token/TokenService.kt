package com.vkashel.utils.auth.token

import com.vkashel.domain.models.User

interface TokenService {
    fun generateToken(user: User): String

    fun verifyToken(token: String)
}
