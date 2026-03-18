package org.example.kotlin.backend.controllers

import io.qameta.allure.Step
import okhttp3.ResponseBody
import org.example.kotlin.backend.api.endpoints.Endpoints
import org.example.kotlin.backend.api.extension.Extensions.Companion.getAsObject
import org.example.kotlin.backend.api.models.users.CreateUserRequest
import org.example.kotlin.backend.api.models.users.CreateUserResponse
import org.example.kotlin.backend.helpers.GarbageCollector
import retrofit2.Response

class UsersController: Endpoints() {

    @Step("Create a new user")
    fun createUser(body: CreateUserRequest): Response<CreateUserResponse> {
        return users.createUser(body).execute()
            .also { GarbageCollector.user.add(it.getAsObject().id) }
    }

    @Step("Get user with id: {id}")
    fun getUserById(token: String, id: Int): Response<CreateUserResponse> {
        return users.getUserById(token, id).execute()
    }

    @Step("Delete user with id: {id}")
    fun deleteUserById(token: String, id: Int): Response<ResponseBody> {
        return users.deleteUserById(token, id).execute()
    }
}