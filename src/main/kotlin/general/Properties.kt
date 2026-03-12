package org.example.kotlin.general

import java.util.Properties

//@Suppress("JAVA_CLASS_ON_COMPANION")
//class Properties {
//
//    companion object {
//        val properties: PropsModel by lazy {
//            val stream = javaClass.getResourceAsStream(System.getProperty("env_config", "/example.properties"))
//                ?: throw IllegalStateException("Properties file not found")
//
//            val props = Properties().apply { load(stream) }
//
//            PropsModel(
//                browserName = props.getProperty("browser.name", "chrome"),
//                browserVersion = props.getProperty("browser.version", "latest"),
//                frontendUrl = props.getProperty("frontend.url", "https://example.com/"),
//                backendUrl = props.getProperty("backend.url", "https://api.example.com/"),
//                moonHost = props.getProperty("moon.host", "selenoid.autotests.cloud")
//            )
//        }
//    }
//
//    data class PropsModel(
//        val browserName: String,
//        val browserVersion: String,
//        val frontendUrl: String,
//        val backendUrl: String,
//        val moonHost: String,
//    )
//}

object Config {
    private val DEFAULT_PROP_FILE = "/example.properties"

    val get: Props by lazy {
        val fileName = System.getProperty("env_config", DEFAULT_PROP_FILE)

        val properties = Properties().apply {
            val stream = Config::class.java.getResourceAsStream(fileName)
                ?: throw IllegalStateException("Properties file '$fileName' not found")
            stream.use { load(it) }
        }

//        fun Properties.getRequiredProperty(key: String): String {
//            return getProperty(key) ?: throw IllegalStateException("Required property '$key' not found in '$fileName'")
//        }

        Props(
            browserName = properties.getProperty("browser.name"),
            browserVersion = properties.getProperty("browser.version"),
            frontendUrl = properties.getProperty("frontend.url"),
            backendUrl = properties.getProperty("backend.url"),
            moonHost = properties.getProperty("moon.host")
        )
    }

    data class Props(
        val browserName: String,
        val browserVersion: String,
        val frontendUrl: String,
        val backendUrl: String,
        val moonHost: String,
    )
}