package bloczek.pl.db.migrations

import bloczek.pl.enums.Category
import bloczek.pl.model.Products
import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class V3_2__create_products : BaseJavaMigration() {
    override fun migrate(context: Context?) {
        transaction {
            SchemaUtils.create(Products)

            Products.insert {
                it[name] = "Product A"
                it[description] = "Lorem ipsum"
                it[category] = Category.SWEATSHIRTS
            }
        }
    }
}