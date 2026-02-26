package frontend

import io.kotest.matchers.collections.shouldContain
import org.example.kotlin.frontend.helpers.BaseUiTest
import org.example.kotlin.frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class ParamCoffeeTest : BaseUiTest() {

    @ParameterizedTest
    @ValueSource(strings = ["Products, Orders, Contact, Cart"])
    @DisplayName("Проверка наличия ссылок в шапке: {link}")
    fun testWithValueSource(link: String) {
        val listLinks = MainPage().header().getLinks()

        listLinks shouldContain link
    }
}