package org.example.kotlin.database

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class JDBCHelper {

    private val jdbcUrl = "jdbc:postgresql://localhost:5432/playground"
    private val username: String = "postgres"
    private val password: String = "postgres"
    private val client = DriverManager.getConnection(jdbcUrl, username, password)

    fun getProducts(): List<Product> {
        val products = mutableListOf<Product>()

        try {
            val statement: Statement = client.createStatement()
            val resultSet: ResultSet = statement.executeQuery("SELECT * FROM table_products")

            while (resultSet.next()) {
                val product = Product(
                    id = resultSet.getInt("id"),
                    name = resultSet.getString("name"),
                    description = resultSet.getString("description"),
                    price = resultSet.getDouble("price")
                )
                products.add(product)
            }

            resultSet.close()
            statement.close()
        } catch (e: Exception) {
            println("Error fetching products: ${e.message}")
        }

        return products
    }

    fun getProductsNew(): List<Product> = client.use { connection ->
        connection.createStatement().use { statement ->
            statement.executeQuery("SELECT * FROM table_products").use { resultSet ->
                generateSequence { resultSet.takeIf { it.next() }?.toProduct() }.toList()
            }
        }
    }
}

fun ResultSet.toProduct() = Product(
    id = getInt("id"),
    name = getString("name"),
    description = getString("description"),
    price = getDouble("price")
)

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
)