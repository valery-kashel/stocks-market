package com.vkashel.infrastructure.configuration.database

import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database

private val url = System.getenv("DATABASE_URL") ?: "jdbc:postgresql://localhost:5432/stocks"
private val user = System.getenv("DATABASE_USER") ?: "root"
private val password = System.getenv("DATABASE_PASSWORD") ?: "super-secure-password"

fun initDbConnection() {
    Database.connect(
        url = url,
        driver = "org.postgresql.Driver",
        user = user,
        password = password,
    )
}

fun runFlywayMigration() {
    Flyway.configure()
        .baselineOnMigrate(true)
        .dataSource(url, user, password).load()
        .migrate()
}
