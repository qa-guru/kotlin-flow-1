package org.example.kotlin.backend.api.models.users

import kotlin.random.Random

data class CreateUserRequest(
    var username: String,
    var password: String,
    var email: String
)

val defaultUser = CreateUserRequest(
    username = "random",
    password = "random",
    email = "auto-${Random.nextInt(10000)}@autotest.com"
)