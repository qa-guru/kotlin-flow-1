package lesson_2

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Calculator Operations")
@Story("Sum Operation Tests")
@Tags(Tag("regression"), Tag("calculator"), Tag("sum"))
class SumTest {

    @Test
    @DisplayName("Test sum of two numbers")
    fun testSumOfTwoNumbers() {
        val a = 5
        val b = 10

        val expectedSum = 15
        val actualSum = a + b

        expectedSum shouldBe actualSum
    }
}