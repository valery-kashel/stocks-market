package com.vkashel.utils.passwordencoder

import kotlin.io.encoding.Base64

class Base64PasswordEncoder : PasswordEncoder {

    @OptIn(kotlin.io.encoding.ExperimentalEncodingApi::class)
    override fun encode(password: String): String {
        return Base64.encode(password.toByteArray())
    }
}