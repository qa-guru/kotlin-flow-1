package lesson_2

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Calculator Operations")
@Story("Minus Operation Tests")
@Tags(Tag("regression"), Tag("calculator"), Tag("minus"))
class MinusTest {

    @Test
    @DisplayName("Test minus of two numbers")
    fun minusOfTwo() {
        val a = 10
        val b = 5

        val expectedMinus = 5
        val actualMinus = a - b

        expectedMinus shouldBe actualMinus
    }
}