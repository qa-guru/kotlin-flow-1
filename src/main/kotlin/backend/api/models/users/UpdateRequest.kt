package org.example.kotlin.backend.api.models.users

data class UpdateRequest(
    val username: String? = null,
    val password: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
)