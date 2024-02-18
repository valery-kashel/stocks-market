package com.vkashel.infrastructure.repository.database

import com.vkashel.domain.models.User
import com.vkashel.domain.ports.UsersRepository
import com.vkashel.infrastructure.repository.database.tables.Users
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.ZonedDateTime

class DBUsersRepository : UsersRepository {
    override fun save(user: User): User {
        transaction {
            Users.insert {
                it[id] = user.id
                it[email] = user.email
                it[password] = user.password
                it[username] = user.username
                it[createdTime] = ZonedDateTime.now().toOffsetDateTime()
                it[updatedTime] = ZonedDateTime.now().toOffsetDateTime()
            }
        }
        return user
    }
}
