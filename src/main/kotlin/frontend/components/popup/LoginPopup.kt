package org.example.kotlin.frontend.components.popup

import com.codeborne.selenide.Selectors.byTestId
import com.codeborne.selenide.Selectors.shadowCss
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step

class LoginPopup {
    private val btnClose get() = element(byTestId("login-close"))
    private val txtTitle get() = element(".title")
    private val inpEmail get() = element(byTestId("login-email")).find(shadowCss(".input"))
    private val inpPassword get() = element(byTestId("login-password")).find(shadowCss(".input"))
    private val btnSubmit get() = element(byTestId("login-submit"))
    private val txtError get() = element(byTestId("login-error"))

    @Step("Нажать кнопку закрытия попапа")
    fun clickCloseButton(): LoginPopup {
        btnClose.click()
        return this
    }

    @Step("Получить заголовок попапа")
    fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Ввести email")
    fun typeEmail(email: String): LoginPopup {
        inpEmail.value = email
        return this
    }

    @Step("Ввести пароль")
    fun typePassword(password: String): LoginPopup {
        inpPassword.value = password
        return this
    }

    @Step("Нажать кнопку 'Войти'")
    fun clickSubmit(): LoginPopup {
        btnSubmit.click()
        return this
    }

    @Step("Получить текст ошибки")
    fun getErrorMessage(): String {
        return txtError.text
    }
}