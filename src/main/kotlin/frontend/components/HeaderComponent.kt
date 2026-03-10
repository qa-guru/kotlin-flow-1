package org.example.kotlin.frontend.components

import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step
import org.example.kotlin.frontend.components.popup.CartPopup
import org.example.kotlin.frontend.helpers.Wrappers.Companion.byTestGroup

class HeaderComponent {
    private val listLinks get() = elements(byTestGroup("nav-link"))

    @Step("Нажать на ссылку в шапке: {name}")
    fun clickLink(name: String): HeaderComponent {
        listLinks.first { it.text.contains(name) }.click()
        return this
    }

    @Step("Получить список ссылок в шапке")
    fun getLinks(): List<String> {
        return listLinks.map { it.text }
    }

    @Step("Получить попап корзины")
    fun navigateCartPopup(): CartPopup {
        return CartPopup()
    }
}