package com.vkashel.application.requests

data class CreateNewUserRequest(
    val email: String,
    val username: String,
    val password: String,
)