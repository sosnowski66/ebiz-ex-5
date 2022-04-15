package bloczek.pl.model

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table


object Products : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val name: Column<String> = varchar("name", 255)
    val description: Column<String> = text("description")
//    val category: Column<Category> = enumeration("category")
 }


//data class Product(
//
//)