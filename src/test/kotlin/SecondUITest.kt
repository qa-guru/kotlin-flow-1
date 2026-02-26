import io.kotest.matchers.collections.shouldHaveSize
import org.example.kotlin.frontend.helpers.BaseUiTest
import org.example.kotlin.frontend.pages.MainPage
import org.example.kotlin.frontend.pages.ProductsPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SecondUITest : BaseUiTest() {

    @Test
    @DisplayName("Проверка навигации по ссылкам в шапке")
    fun testNavigation() {
        MainPage()
            .header()
            .clickLink("LolKek")
        val products = ProductsPage()
            .getProducts()

        products.shouldHaveSize(7)
    }
}