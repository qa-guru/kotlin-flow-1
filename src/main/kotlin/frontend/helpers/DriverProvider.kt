package org.example.kotlin.frontend.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.WebDriverProvider
import org.openqa.selenium.Capabilities
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URI

open class DriverProvider : WebDriverProvider {
    private val BROWSER_NAME = System.getProperty("browser", "chrome")

    init {
        Configuration.timeout = 15_000 // default is 4000ms, but you can adjust it as needed
        Configuration.pageLoadStrategy = "normal" // default is "normal", but you can change it to "eager" or "none" if needed
        Configuration.reopenBrowserOnFail = true // default is true, but you can set it to false if you don't want to reopen the browser on failure
        Configuration.baseUrl = "https://www.google.com"
    }

    override fun createDriver(capabilities: Capabilities): RemoteWebDriver {
        return when (BROWSER_NAME) {
            "chrome" -> {
                ChromeOptions().apply {
                    setCapability("browserVersion", "128")
                    setCapability(
                        "selenoid:options",
                        mapOf(
                            "headless" to false,
                            "enableVNC" to true,
                            "acceptInsecureCerts" to true,
                            "screenResolution" to "1920x1080" // You can adjust the screen resolution as needed
                        )
                    )
                    addArguments("--disable-gpu")
                    addArguments("window-size=1920,1080") // Set the Chrome window size to match the screen resolution
                }
            }

            else -> throw Error("Browser is not defined")
        }
            .run { RemoteWebDriver(URI("https://user1:1234@selenoid.autotests.cloud/wd/hub").toURL(), this) }
            .apply { this.fileDetector = LocalFileDetector() } // This is necessary for file upload functionality to work correctly when using RemoteWebDriver
    }
}