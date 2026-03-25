package org.example.kotlin.backend.api.endpoints

import okhttp3.ResponseBody
import org.example.kotlin.backend.api.endpoints.headers.Headers
import org.example.kotlin.backend.api.models.products.CreateProductRequest
import org.example.kotlin.backend.api.models.products.CreateProductResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductsEndpoints {

    @GET("products")
    fun getProducts(): Call<List<CreateProductResponse>>

    @GET("products/{id}")
    fun getProductById(@Path("id") id: Any): Call<CreateProductResponse>

    @POST("products/create")
    fun postCreateProduct(@Header(Headers.AUTHORIZATION) token: String, @Body body: CreateProductRequest): Call<CreateProductResponse>

    @DELETE("products/{id}")
    fun deleteProductById(@Header(Headers.AUTHORIZATION) token: String, @Path("id") id: Any): Call<ResponseBody>
}