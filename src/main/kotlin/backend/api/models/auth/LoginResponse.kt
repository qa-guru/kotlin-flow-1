package org.example.kotlin.backend.api.models.auth

data class LoginResponse(
    var id: Int,
    var accessToken: String,
    var refreshToken: String,
    var createdAt: Long,
    var expireInMs: Long
)