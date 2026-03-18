package org.example.kotlin.backend.api.models.auth

data class LoginRequest(
    var email: String,
    var password: String
)

val defaultAdmin = LoginRequest(
    email = "random@test.com",
    password = "random"
)