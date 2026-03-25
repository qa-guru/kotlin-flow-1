package org.example.kotlin.general

import com.codeborne.selenide.Screenshots
import com.codeborne.selenide.Selenide
import io.qameta.allure.Attachment
import org.example.kotlin.backend.api.extension.Extensions.Companion.getAsObject
import org.example.kotlin.backend.controllers.Controllers
import org.example.kotlin.backend.helpers.AuthorizationHelper
import org.example.kotlin.backend.helpers.GarbageCollector
import org.junit.platform.engine.TestExecutionResult
import org.junit.platform.launcher.TestExecutionListener
import org.junit.platform.launcher.TestIdentifier
import org.junit.platform.launcher.TestPlan

class TestListener : Controllers(), TestExecutionListener {
    private val authHelper = AuthorizationHelper()

    override fun testPlanExecutionStarted(testPlan: TestPlan) {
        println("|------ Test Plan Started -----|")
        println("Initializing Configurations...").also { Config.get }
//        println("Initializing Selenide WebDriver...").also { Configuration.browser = DriverProvider::class.java.name }
    }

    override fun executionFinished(testIdentifier: TestIdentifier, testExecutionResult: TestExecutionResult) {
        if (testIdentifier.isTest) println("Finished test: ${testIdentifier.displayName} - Result: ${testExecutionResult.status}")
        if (testExecutionResult.status == TestExecutionResult.Status.FAILED && testIdentifier.displayName != "JUnit Jupiter") {
            attachScreenshot()
        }
    }

    override fun executionSkipped(testIdentifier: TestIdentifier, reason: String) {
        if (testIdentifier.isTest) println("Ignoring test: ${testIdentifier.displayName} - Reason: $reason")
    }

    override fun testPlanExecutionFinished(testPlan: TestPlan) {
        println("|------ Test Plan Finished -----|")
        Selenide.closeWebDriver()
        println("|------ GarbageCollector -----|")

        GarbageCollector.user.forEach { id ->
            users.deleteUserById(token = authHelper.getAdminToken(), id = id).also { println("Deleted User: $id") }
        }

        GarbageCollector.products.forEach { id ->
            products.deleteProductById(token = authHelper.getAdminToken(), id = id).also { println("Deleted Product: $id") }
        }

//        users.getAllUsers(token = authHelper.getAdminToken(), offset = 1, limit = 50).getAsObject().forEach { user ->
//            if (user.email.contains("@autotest.com")) {
//                users.deleteUserById(token = authHelper.getAdminToken(), id = user.id).also { println("Deleted User: ${user.email}") }
//            }
//        }
    }

    @Attachment(value = "{name}", type = "image/png")
    fun attachScreenshot(name: String = "SCREENSHOT"): ByteArray? {
        return Screenshots.takeScreenShotAsFile()?.readBytes()
    }
}