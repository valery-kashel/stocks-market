package com.vkashel.infrastructure.repository.database.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestampWithTimeZone

object Users : Table("users") {
    val id = text("id")
    val email = varchar("email", 200)
    val username = varchar("username", 200)
    val password = varchar("password", 300)
    val role = varchar("role", 100)
    val createdTime = timestampWithTimeZone("created_time")
    val updatedTime = timestampWithTimeZone("updated_time")
}
