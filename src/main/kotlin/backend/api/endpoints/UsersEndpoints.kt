package org.example.kotlin.backend.api.endpoints

import okhttp3.ResponseBody
import org.example.kotlin.backend.api.endpoints.headers.Headers
import org.example.kotlin.backend.api.models.users.CreateUserRequest
import org.example.kotlin.backend.api.models.users.CreateUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface UsersEndpoints {

    @POST("users/create")
    fun createUser(@Body body: CreateUserRequest) : Call<CreateUserResponse>

    @GET("users/{id}")
    fun getUserById(@Header(Headers.AUTHORIZATION) token: String, @Path("id") id: Int): Call<CreateUserResponse>

    @DELETE("users/{id}")
    fun deleteUserById(@Header(Headers.AUTHORIZATION) token: String, @Path("id") id: Int) : Call<ResponseBody>
}