package backend

import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import org.example.kotlin.backend.api.extension.Extensions.Companion.getAsObject
import org.example.kotlin.backend.api.extension.Extensions.Companion.getErrorAsObject
import org.example.kotlin.backend.api.models.ErrorResponse
import org.example.kotlin.backend.controllers.Controllers
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LoginTest : Controllers() {

    @Test
    @DisplayName("Login with valid credentials should return access token and refresh token")
    fun testLoginWithValidCredentials() {
        val response = auth.login("random@test.com", "random").getAsObject()

        response.accessToken.length shouldBeGreaterThan 10
        response.refreshToken.length shouldBeGreaterThan 10
    }

    @Test
    @DisplayName("Login with invalid credentials should return error")
    fun testLoginWithInvalidCredentials() {
        val response = auth.login("invalid", "credentials").getErrorAsObject<ErrorResponse>()

        response.code shouldBe 400
        response.reason shouldBe "Invalid email or password"
    }
}