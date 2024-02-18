package com.vkashel.infrastructure.repository.database

import com.vkashel.domain.ports.UsersRepository
import com.vkashel.infrastructure.configuration.Repositories
import com.vkashel.infrastructure.configuration.database.initDbConnection
import com.vkashel.infrastructure.configuration.database.runFlywayMigration

class DatabaseRepositories : Repositories {
    init {
        initDbConnection()
        runFlywayMigration()
    }

    override val usersRepository: UsersRepository = DBUsersRepository()
}
