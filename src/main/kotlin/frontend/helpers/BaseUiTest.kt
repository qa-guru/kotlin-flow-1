package org.example.kotlin.frontend.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.FileDownloadMode
import com.codeborne.selenide.Selenide
import org.example.kotlin.general.TestListener
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestListener::class)
open class BaseUiTest {

    init {
        Configuration.timeout = 15_000
        Configuration.pageLoadStrategy = "normal"
        Configuration.reopenBrowserOnFail = true
        Configuration.baseUrl = "http://localhost:4000"

//        Configuration.timeout = 15_000
//        Configuration.pageLoadStrategy = "normal"
//        Configuration.reopenBrowserOnFail = true
//        Configuration.baseUrl = "https://www.google.com"
//        Configuration.browser = DriverProvider::class.java.name
    }

    @BeforeEach
    fun openBrowser() {
        Selenide.open("/")
    }

    @AfterEach
    fun clearBrowser() {
        Selenide.clearBrowserCookies()
        Selenide.clearBrowserLocalStorage()
    }
}