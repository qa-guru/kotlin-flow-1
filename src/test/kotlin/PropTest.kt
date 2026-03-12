import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PropTest {

    @Test
    @DisplayName("Проверка загрузки свойств из файла")
    fun testPropertiesLoading() {
        val a = 5
        val b = 10

        a shouldBe b
    }

    @Test
    @Disabled("Not implemented yet")
    @DisplayName("Проверка загрузки свойств из переменных окружения")
    fun testEnvironmentVariables() {
        // lol kek
    }

    @Test
    @DisplayName("Проверка загрузки свойств из аргументов командной строки")
    fun testDefaultValues() {
        val a = 5
        val b = 5

        a shouldBe b
    }
}