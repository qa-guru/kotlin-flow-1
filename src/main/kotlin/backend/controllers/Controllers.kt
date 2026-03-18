package org.example.kotlin.backend.controllers

open class Controllers {
    protected val auth get() = AuthController()
    protected val users get() = UsersController()
}