import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import io.kotest.matchers.shouldBe
import org.example.kotlin.frontend.helpers.BaseUiTest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ThirdTest : BaseUiTest() {

    @Test
    @DisplayName("Проверка открытия Google")
    @Disabled("Тест для Remote WebDriver")
    fun testOpenGoogle() {
        Selenide.open("https://www.google.com")
        val title = Selenide.title()
        sleep(10_000)
        title shouldBe "Google"
    }
}