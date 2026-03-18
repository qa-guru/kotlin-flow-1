package org.example.kotlin.backend.helpers

import io.qameta.allure.Step
import org.example.kotlin.backend.api.extension.Extensions.Companion.getAsObject
import org.example.kotlin.backend.api.extension.Extensions.Companion.toBearer
import org.example.kotlin.backend.api.models.auth.defaultAdmin
import org.example.kotlin.backend.controllers.Controllers

class AuthorizationHelper: Controllers() {

    @Step("Get authorization token")
    fun getToken(email: String, password: String): String {
        return auth.login(email, password).getAsObject().accessToken.toBearer()
    }

    @Step("Get ADMIN token")
    fun getAdminToken(): String {
        return auth.login(email = defaultAdmin.email, password = defaultAdmin.password).getAsObject().accessToken.toBearer()
    }
}