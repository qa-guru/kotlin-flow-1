package org.example.kotlin.backend.api.models.products

data class CreateProductRequest(
    var name: String,
    var price: Double,
    var description: String
)