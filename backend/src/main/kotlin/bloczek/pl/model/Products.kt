package bloczek.pl.model

import bloczek.pl.db.postgresEnumeration
import bloczek.pl.enums.Category
import bloczek.pl.enums.Subcategory
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

object Products : Table() {
    val id: Column<Int> = integer("product_id").autoIncrement()
    val name: Column<String> = varchar("name", 255)

    val description: Column<String> = text("description")
    val price: Column<BigDecimal> = decimal("price", 6, 2)
    val brand: Column<Int> = reference("brand_id", Brands.id)

    val category = postgresEnumeration<Category>("category", "Category")
    val subcategory = postgresEnumeration<Subcategory>("subcategory", "Subcategory")

    fun toProduct(row: ResultRow) = Product(
        id = row[id],
        name = row[name],
        description = row[description],
        category = row[category]
    )
}

data class Product(
    val id: Int? = null,
    val name: String,
    val description: String? = null,
    val category: Category
)
