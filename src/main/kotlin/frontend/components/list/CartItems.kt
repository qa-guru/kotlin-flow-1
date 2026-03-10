package org.example.kotlin.frontend.components.list

import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import org.example.kotlin.frontend.helpers.Wrappers.Companion.byTestGroup

class CartItems {
    private val listCartProducts get() = elements(byTestGroup("cart-item"))

    fun getItems(): List<CartItem> {
        return listCartProducts
            .map {
                CartItem(
                    image = it.find(byTestGroup("cart-item-image")),
                    name = it.find(byTestGroup("cart-item-name")).text,
                    price = it.find(byTestGroup("cart-item-price")).text.filter { it.isDigit() }.toFloat() / 100f,
                    btnIncrement = it.find(byTestGroup("cart-item-increment")),
                    quantity = it.find(byTestGroup("cart-item-qty")).text.toInt(),
                    btnDecrement = it.find(byTestGroup("cart-item-decrement")),
                )
            }
    }
}

data class CartItem(
    val image: SelenideElement,
    var name: String,
    val price: Float,
    val btnDecrement: SelenideElement,
    val quantity: Int,
    val btnIncrement: SelenideElement,
)