package org.example.kotlin.frontend.pages

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.example.kotlin.frontend.helpers.Wrappers.Companion.byDataTestGroup
import org.example.kotlin.frontend.helpers.Wrappers.Companion.byDataTestId

class ProductsPage {
    private val txtTitle get() = element(byDataTestId("products-title"))
    private val listItems get() = elements(byDataTestGroup("product-card"))

    @Step("Получить название страницы продуктов")
     fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Получить список продуктов на странице")
    fun getProducts(): ElementsCollection {
        return listItems
    }
}