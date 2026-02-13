import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.TmsLink
import org.example.kotlin.frontend.helpers.BaseUiTest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class FirstUITest : BaseUiTest() {

    @Test
    @TmsLink("TEST-1")
    @Disabled("Just for demonstration purposes")
    fun testFirstUI() {
        val searchInput = element("[name='q']")
        searchInput.value = "Selenide"
        searchInput.pressEnter()
        Selenide.sleep(5000)
    }
}