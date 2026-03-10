package org.example.kotlin.frontend.components.popup

import com.codeborne.selenide.Selectors.byTestId
import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import org.example.kotlin.frontend.components.list.CartItem
import org.example.kotlin.frontend.components.list.CartItems

class CartPopup {
    private val txtTotalPrice get() = element(byTestId("cart-total-price"))
    private val btnCheckout get() = element(byTestId("cart-checkout"))
    private val listCartProducts get() = CartItems().getItems()

    @Step("Получить список продуктов в корзине")
    fun getProducts(): List<CartItem> {
        return listCartProducts
    }

    @Step("Получить общую стоимость товаров в корзине")
    fun getTotalPrice(): Float {
        return txtTotalPrice.text.filter { it.isDigit() }.toFloat() / 100f
    }
}