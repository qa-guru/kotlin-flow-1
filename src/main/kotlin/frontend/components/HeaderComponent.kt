package org.example.kotlin.frontend.components

import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step
import org.example.kotlin.frontend.helpers.Wrappers.Companion.byDataTestGroup

class HeaderComponent {
    private val linksHeader get() = elements(byDataTestGroup("nav-link"))

    @Step("Нажать на ссылку в шапке: {name}")
    fun clickLink(name: String): HeaderComponent {
        linksHeader.first { it.text == name }.click()
        return this
    }
}