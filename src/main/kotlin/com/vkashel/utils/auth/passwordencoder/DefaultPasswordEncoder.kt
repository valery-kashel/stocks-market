package com.vkashel.utils.auth.passwordencoder

import java.nio.charset.Charset
import java.security.MessageDigest
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

class DefaultPasswordEncoder : PasswordEncoder {
    private val digest = MessageDigest.getInstance("SHA-512")

    @OptIn(ExperimentalEncodingApi::class)
    override fun encode(password: String): String {
        return Base64.encode(
            digest.digest(
                password.toByteArray(Charset.defaultCharset()),
            ),
        )
    }
}
