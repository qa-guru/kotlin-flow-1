package org.example.kotlin.frontend.pages

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step
import org.example.kotlin.frontend.components.list.ProductItem
import org.example.kotlin.frontend.components.list.ProductItems
import org.example.kotlin.frontend.helpers.Wrappers.Companion.byTestGroup
import org.example.kotlin.frontend.helpers.Wrappers.Companion.byTestId

class ProductsPage {
    private val txtTitle get() = element(byTestId("products-title"))
    private val listItems get() = elements(byTestGroup("product-card"))
    private val listProducts get() = ProductItems().getItems()

    @Step("Открыть страницу продуктов")
    fun open(): ProductsPage {
        Selenide.open("/products")
        return this
    }

    @Step("Получить название страницы продуктов")
     fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Получить список продуктов на странице")
    fun getProducts(): ElementsCollection {
        return listItems
    }

    @Step("Получить список продуктов на странице в виде объектов")
    fun getProductsAsObjects(): List<ProductItem> {
        return listProducts
    }
}