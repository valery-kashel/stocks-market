package com.vkashel.utils.auth.passwordencoder

interface PasswordEncoder {
    fun encode(password: String): String

    fun match(
        value: String,
        encoded: String,
    ): Boolean {
        return encode(value) == encoded
    }
}
