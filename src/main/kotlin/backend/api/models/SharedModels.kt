package org.example.kotlin.backend.api.models

data class ErrorResponse(
    var code: Int,
    var reason: String
)