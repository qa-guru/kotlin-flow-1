package org.example.kotlin.frontend.components.popup

import com.codeborne.selenide.Selectors.byTestId
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step

class CreateUserPopup {
    private val linkLogin get() = element(byTestId("create-login"))

    @Step("Нажать на ссылку 'Войти' в попапе создания пользователя")
    fun clickLinkLogin(): LoginPopup {
        linkLogin.click()
        return LoginPopup()
    }
}