package frontend.cart

import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.equality.shouldBeEqualToDifferentTypeIgnoringFields
import io.kotest.matchers.equality.shouldBeEqualToIgnoringFields
import io.kotest.matchers.shouldBe
import org.example.kotlin.frontend.components.list.ProductItem
import org.example.kotlin.frontend.helpers.BaseUiTest
import org.example.kotlin.frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CartTest : BaseUiTest() {

    @Test
    @DisplayName("Check products in cart")
    fun testProductsInCart() {
        MainPage()
            .open()
            .getPopularProducts()
            .first().btnIncrement.click()

        val firstCartItem = MainPage()
            .navigateHeader()
            .clickLink("Cart")
            .navigateCartPopup()
            .getProducts()
            .first()

        val firstPopularItem = MainPage().getPopularProducts().first()

        firstPopularItem.name shouldBe firstCartItem.name
        firstPopularItem.quantity shouldBe firstCartItem.quantity
        firstPopularItem.image shouldBe firstCartItem.image
        firstPopularItem.price shouldBe firstCartItem.price

        firstPopularItem.shouldBeEqualToDifferentTypeIgnoringFields(
            firstCartItem,
            ProductItem::description,
            ProductItem::btnDecrement,
            ProductItem::btnIncrement,
            ProductItem::image
        )
    }
}