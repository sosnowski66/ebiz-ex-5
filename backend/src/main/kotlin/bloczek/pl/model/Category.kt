package bloczek.pl.model

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Categories : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val name: Column<String> = varchar("name", 255)

    override val primaryKey: PrimaryKey = PrimaryKey(id, name = "PK_Categories_Id")

//    fun toEntity(row: ResultRow) = Category(
//            id = row[id],
//            name = row[name]
//        )
}
