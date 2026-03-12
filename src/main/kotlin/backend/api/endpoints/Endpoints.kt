package org.example.kotlin.backend.api.endpoints

import org.example.kotlin.backend.api.RetrofitClient

open class Endpoints {
    protected val auth: AuthEndpoints by lazy { RetrofitClient.createService(AuthEndpoints::class.java) }
}