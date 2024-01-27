package com.vkashel.utils.passwordencoder

interface PasswordEncoder {
    fun encode(password: String): String
}
