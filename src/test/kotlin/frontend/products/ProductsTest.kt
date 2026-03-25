package frontend.products

import io.kotest.matchers.shouldBe
import org.example.kotlin.backend.helpers.ProductsHelper
import org.example.kotlin.frontend.helpers.BaseUiTest
import org.example.kotlin.frontend.pages.ProductsPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProductsTest: BaseUiTest() {
    val productsHelper = ProductsHelper()

    @Test
    @DisplayName("Check that 5 products exist")
    fun testFiveProductsExist() {
        val listOfProducts = productsHelper.createProducts(5).sortedByDescending { it.name } // НЕ ЗАБЫВАТЬ

        val products = ProductsPage()
            .open()
            .getProductsAsObjects()
            .sortedByDescending { it.name } // НЕ ЗАБЫВАТЬ

        products.size shouldBe 5
        products.forEachIndexed { index, product ->
            product.name.uppercase() shouldBe listOfProducts[index].name.uppercase()
        }
    }
}