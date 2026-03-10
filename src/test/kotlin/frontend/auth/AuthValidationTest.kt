package frontend.auth

import io.kotest.matchers.shouldBe
import org.example.kotlin.frontend.components.popup.CreateUserPopup
import org.example.kotlin.frontend.helpers.BaseUiTest
import org.example.kotlin.frontend.pages.MainPage
import org.junit.jupiter.api.Test

class AuthValidationTest : BaseUiTest() {

    @Test
    fun testInvalidCredentials() {
        MainPage()
            .open()
            .navigateHeader()
            .clickLink("Join")
        val error = CreateUserPopup()
            .clickLinkLogin()
            .typeEmail(email = "asd")
            .typePassword(password = "asd")
            .clickSubmit()
            .getErrorMessage()

        error shouldBe "Invalid email or password"
    }
}