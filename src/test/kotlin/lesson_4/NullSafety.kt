package lesson_4

import org.junit.jupiter.api.Test

class NullSafety {
    lateinit var lol: String

    @Test
    fun nullSafety() {
        var name: String? = "John Doe"
        println("Name length: ${name?.length ?: "Name is null"}")

        println(lol) // This will throw an exception if 'lol' is not initialized

        name = null
        val length = name?.length ?: 0
        println("Name length with Elvis operator: $length")

        try {
            val nonNullName = name!!
            println("This will not print: $nonNullName")
        } catch (e: NullPointerException) {
            println("Caught a NullPointerException when using !! operator")
        }
    }
}