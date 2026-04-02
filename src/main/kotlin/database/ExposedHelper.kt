package org.example.kotlin.database

import org.jetbrains.exposed.v1.core.ResultRow
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.selectAll
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class ExposedHelper {
    private val jdbcUrl = "jdbc:postgresql://localhost:5432/playground"
    private val username: String = "postgres"
    private val password: String = "postgres"

    fun getAllProductsExposed(): List<ProductExposed> {
        val database = Database.connect(
            url = jdbcUrl,
            driver = "org.postgresql.Driver",
            user = username,
            password = password
        )

        return transaction(database) {
            ProductEntity
                .selectAll()
                .map { ProductEntity.toModel(it) }
        }.also { database.connector().close()  }
    }
}

object ProductEntity : IntIdTable("table_products") {
    var Name = varchar("name", 100)
    var Description = varchar("description", 255)
    var Price = double("price")
}

fun ProductEntity.toModel(resultRow: ResultRow) = ProductExposed(
    id = resultRow[id].value,
    name = resultRow[ProductEntity.Name],
    description = resultRow[ProductEntity.Description],
    price = resultRow[ProductEntity.Price]
)

data class ProductExposed(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
)