package com.vkashel.utils.auth.passwordencoder

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DefaultPasswordEncoderTest {
    private val encoder = DefaultPasswordEncoder()

    @Test
    fun `encode should return encoded value`() {
        val expected = "qUncOnM3guAjSdWb+lbVa6Jj9nB6pXbxduqIHWtpKOUN1pY0F5gh35rRnuz18Mwrb8bWvFt5fskjgNsJ/b0hVQ=="
        val result = encoder.encode("super-secure-password")

        assertEquals(expected, result)
    }

    @Test
    fun `match should return true for equal encoded and decoded value`() {
        val value = "super-secure-password"
        val encoded = "qUncOnM3guAjSdWb+lbVa6Jj9nB6pXbxduqIHWtpKOUN1pY0F5gh35rRnuz18Mwrb8bWvFt5fskjgNsJ/b0hVQ=="

        assertTrue(encoder.match(value, encoded))
    }
}
