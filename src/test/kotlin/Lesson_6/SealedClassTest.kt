package Lesson_6

import org.junit.jupiter.api.Test

class SealedClassTest {
    private val a: String = "lolkek"
    private val b: String = "asdasd"
    private val c: Int = 404

    @Test
    fun testSealedClass() {
        val str = when (a) {
            b -> {
                println("a and b are equal")
                "Strings are equal"
            }

            else -> {
                println("a and b are not equal")
                "Strings are not equal"
            }
        }

        val ifKek: String = if (a == b) "" else ""
    }

    fun String.json(): String {
        return "Parsed JSON from string: $this"
    }

    sealed class Response {
        data object Loading
        data class Success(val json: String)
        data class Error(val code: Int, val message: String)
    }

    fun handleResponse(response: Response) {
        // Ветка else НЕ НУЖНА. Компилятор знает, что других вариантов нет.
        val result = when (response) {
            is Response.Loading -> "Please wait..."
            is Response.Success -> "Data: ${response.json}"
            is Response.Error -> "Oops! Error ${response.code}: ${response.message}"
        }
        println(result)
    }
}

//public sealed abstract class Response permits Loading, Success, Error {}
//
//final class Loading extends Response {}
//final class Success extends Response { /* поля */ }
//final class Error extends Response { /* поля */ }
