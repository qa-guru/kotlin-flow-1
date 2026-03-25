package org.example.kotlin.backend.controllers

open class Controllers {
    val auth get() = AuthController()
    val users get() = UsersController()
    val products get() = ProductsController()
}