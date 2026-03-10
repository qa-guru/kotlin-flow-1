package org.example.kotlin.frontend.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import org.example.kotlin.frontend.components.HeaderComponent
import org.example.kotlin.frontend.components.list.ProductItem
import org.example.kotlin.frontend.components.list.ProductItems
import org.example.kotlin.frontend.helpers.Wrappers.Companion.byTestId

class MainPage {
    private val txtTitle get() = element(byTestId("main-image-text"))
    private val listPopularProducts get() = ProductItems().getItems()

    @Step("Открыть главную страницу")
    fun open(): MainPage {
        Selenide.open("/")
        return this
    }

    @Step("Получить название кофейни")
    fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Перейти к компоненту Header")
    fun navigateHeader(): HeaderComponent {
        return HeaderComponent()
    }

    @Step("Получить список популярных товаров")
    fun getPopularProducts(): List<ProductItem> {
        return listPopularProducts
    }
}