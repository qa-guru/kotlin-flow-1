package org.example.kotlin.general

import com.codeborne.selenide.Screenshots
import com.codeborne.selenide.Selenide
import io.qameta.allure.Attachment
import org.junit.platform.engine.TestExecutionResult
import org.junit.platform.launcher.TestExecutionListener
import org.junit.platform.launcher.TestIdentifier
import org.junit.platform.launcher.TestPlan

class TestListener : TestExecutionListener {

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
        Selenide.closeWebDriver()
        println("|------ Test Plan Finished -----|")
    }

    @Attachment(value = "{name}", type = "image/png")
    fun attachScreenshot(name: String = "SCREENSHOT"): ByteArray? {
        return Screenshots.takeScreenShotAsFile()?.readBytes()
    }
}