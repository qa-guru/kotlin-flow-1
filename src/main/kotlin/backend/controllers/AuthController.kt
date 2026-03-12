package org.example.kotlin.backend.controllers

import io.qameta.allure.Step
import org.example.kotlin.backend.api.endpoints.Endpoints
import org.example.kotlin.backend.api.models.auth.LoginRequest
import org.example.kotlin.backend.api.models.auth.LoginResponse
import retrofit2.Response

class AuthController: Endpoints() {

    @Step("Login with email: {email} and password: {password}")
    fun login(email: String, password: String): Response<LoginResponse> {
        return auth.postLogin(body = LoginRequest(email = email, password = password)).execute()
    }
}