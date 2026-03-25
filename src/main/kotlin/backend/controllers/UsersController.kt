package org.example.kotlin.backend.controllers

import io.qameta.allure.Step
import okhttp3.ResponseBody
import org.example.kotlin.backend.api.endpoints.Endpoints
import org.example.kotlin.backend.api.extension.Extensions.Companion.getAsObject
import org.example.kotlin.backend.api.models.users.CreateUserRequest
import org.example.kotlin.backend.api.models.users.CreateUserResponse
import org.example.kotlin.backend.api.models.users.UpdateRequest
import org.example.kotlin.backend.helpers.AuthorizationHelper
import org.example.kotlin.backend.helpers.GarbageCollector
import retrofit2.Response

class UsersController: Endpoints() {
    private val authHelper = AuthorizationHelper()

    @Step("Get all users")
    fun getAllUsers(token: String = authHelper.getAdminToken(), offset: Int = 0, limit: Int = 50): Response<List<CreateUserResponse>> {
        return users.getUsers(token, offset, limit).execute()
    }

    @Step("Create a new user")
    fun createUser(body: CreateUserRequest): Response<CreateUserResponse> {
        return users.createUser(body).execute()
            .also { GarbageCollector.user.add(it.getAsObject().id) }
    }

    @Step("Get user with id: {id}")
    fun getUserById(token: String = authHelper.getAdminToken(), id: Int): Response<CreateUserResponse> {
        return users.getUserById(token, id).execute()
    }

    @Step("Update user with id: {id}")
    fun updateUserById(token: String = authHelper.getAdminToken(), id: Int, body: UpdateRequest) : Response<CreateUserResponse> {
        return users.putUserById(token, id, body).execute()
    }

    @Step("Delete user with id: {id}")
    fun deleteUserById(token: String = authHelper.getAdminToken(), id: Int): Response<ResponseBody> {
        return users.deleteUserById(token, id).execute()
    }
}