package com.vkashel.utils.auth.token

import com.vkashel.domain.models.User
import com.vkashel.utils.TokenExpiredException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import java.time.Instant
import java.util.Date

class JWTTokenService(
    secretKey: String,
) : TokenService {
    private val signKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey))
    private val expPeriodInMillis = 1 * 60 * 1000L

    override fun generateToken(user: User): String {
        return Jwts.builder()
            .claim("userId", user.id)
            .claim("role", user.role.name)
            .expiration(
                Date.from(
                    Instant.now()
                        .plusMillis(expPeriodInMillis),
                ),
            )
            .signWith(signKey)
            .compact()
    }

    override fun verifyToken(token: String) {
        val claims =
            Jwts.parser()
                .decryptWith(signKey)
                .build()
                .parseSignedClaims(token)
        if (claims.payload.expiration < Date.from(Instant.now())) {
            throw TokenExpiredException()
        }
    }
}
