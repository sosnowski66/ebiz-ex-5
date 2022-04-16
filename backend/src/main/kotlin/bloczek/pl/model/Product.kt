package bloczek.pl.model

import bloczek.pl.enums.Category
import bloczek.pl.enums.postgresEnumeration
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table


object Products : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val name: Column<String> = varchar("name", 255)
    val description: Column<String> = text("description")
    val category = postgresEnumeration<Category>("category", "Category")

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
    val description: String?,
    val category: Category
)