package com.vkashel.utils.auth.passwordencoder

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Base64PasswordEncoderTest {
    private val encoder = Base64PasswordEncoder()

    @Test
    fun `encode should return encoded value`() {
        val expected = "c3VwZXItc2VjdXJlLXBhc3N3b3Jk"
        val result = encoder.encode("super-secure-password")

        assertEquals(expected, result)
    }

    @Test
    fun `match should return true for equal encoded and decoded value`() {
        val value = "super-secure-password"
        val encoded = "c3VwZXItc2VjdXJlLXBhc3N3b3Jk"

        assertTrue(encoder.match(value, encoded))
    }
}
