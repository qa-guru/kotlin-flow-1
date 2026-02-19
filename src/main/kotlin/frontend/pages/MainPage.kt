package org.example.kotlin.frontend.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.example.kotlin.frontend.components.HeaderComponent
import org.example.kotlin.frontend.helpers.Wrappers.Companion.byDataTestId

class MainPage {

    private val txtTitle get() = element(byDataTestId("main-image-text"))

    @Step("Открыть главную страницу")
    fun open() {
        Selenide.open("/")
    }

    @Step("Получить название кофейни")
    fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Перейти к компоненту Header")
    fun header(): HeaderComponent {
        return HeaderComponent()
    }
}