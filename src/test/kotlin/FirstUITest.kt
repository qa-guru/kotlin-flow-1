import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.example.kotlin.frontend.helpers.BaseUiTest
import org.example.kotlin.frontend.pages.MainPage
import org.example.kotlin.frontend.pages.ProductsPage
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FirstUITest : BaseUiTest() {

    @Test
    @DisplayName("Проверка названия кофейни на главной странице")
    fun testFirstUI() {
        val title = MainPage()
            .getTitle()

        title shouldBe "Welcome to Brew & Bean"
    }
}