package Lesson_5


import org.junit.jupiter.api.Test

class InlineFunctionsTest {

    @Test
    fun testLolKek() {
        inlineFunctionExample {
            println("This is an inline function example.")
        }

        val intValue: Int = inlineFunctionWithReifiedType<Int>("123")
        println("Converted to Int: $intValue")

        val stringValue: String = inlineFunctionWithReifiedType<String>("Hello, World!")
        println("It's a String: $stringValue")
    }
}


inline fun inlineFunctionExample(body: () -> Unit) {
    body()
}

//inline fun <T> inlineFunctionWithReturn(body: () -> T): T {
//    T::class.java
//    return body()
//}

inline fun <reified T> inlineFunctionWithReifiedType(str: String): T {
    return when (T::class.java) {
        String::class.java -> println("It's a String!") as T
        Int::class.java -> str.toInt() as T
        Double::class.java -> str.toDouble() as T
        Float::class.java -> str.toFloat() as T
        else -> throw IllegalArgumentException("Unsupported type")
    }
}
