package org.example.kotlin.backend.helpers

import io.qameta.allure.Step
import org.example.kotlin.backend.api.extension.Extensions.Companion.getAsObject
import org.example.kotlin.backend.api.models.products.CreateProductRequest
import org.example.kotlin.backend.api.models.products.CreateProductResponse
import org.example.kotlin.backend.controllers.Controllers

class ProductsHelper : Controllers() {

    @Step("Create number of products: {count}")
    fun createProducts(count: Int): List<CreateProductResponse> {
        val listOfProducts = mutableListOf<CreateProductResponse>()

        repeat(count) { index ->
            listOfProducts.add(
                products.createProduct(
                    product = CreateProductRequest(
                        "Product #$index",
                        description = "Description for product #$index",
                        price = index+1.toDouble()
                    )
                ).getAsObject()
            )
        }

        return listOfProducts.toList()
    }
}