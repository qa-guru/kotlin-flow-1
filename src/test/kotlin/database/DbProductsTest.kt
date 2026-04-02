package database

import org.example.kotlin.database.ExposedHelper
import org.example.kotlin.database.JDBCHelper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DbProductsTest {

    // 147ms - JDBC
    @Test
    @DisplayName("Test fetching all products from the database -> basic JDBC")
    fun testGetAllProducts() {
        val jdbcClient = JDBCHelper()

        val products = jdbcClient.getProducts()

        println(products)
    }

    // 170ms - Kotlin JDBC
    @Test
    @DisplayName( "Test fetching all products from the database -> Kotlin JDBC")
    fun testGetAllProductsKotlin() {
        val jdbcClient = JDBCHelper()

        val products = jdbcClient.getProductsNew()

        println(products)
    }

    // 385ms -> Exposed ORM
    @Test
    @DisplayName("Test fetching all products from the database -> Exposed ORM")
    fun testGetAllProductsExposed() {
        val exposedHelper = ExposedHelper()

        val product = exposedHelper.getAllProductsExposed()

        println(product)
    }
}