package org.example.kotlin.backend.api.models.users

data class CreateUserResponse(
    var id: Int,
    var username: String,
    var email: String,
    var phoneNumber: String,
    var createdAt: Long
)