package bloczek.pl

import bloczek.pl.model.Products
import bloczek.pl.db.DatabaseFactory
import bloczek.pl.db.DatabaseFactory.dbQuery
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.inject
import org.jetbrains.exposed.sql.*

val helloAppModule = module {
    single { HelloServiceImpl(get()) } // get() Will resolve bloczek.pl.HelloRepository
    single { HelloRepository() }
}

interface HelloService {
    fun sayHello(): String
}

class HelloServiceImpl(val helloRepository: HelloRepository) : HelloService {
    override fun sayHello() = "Hello ${helloRepository.getHello()} !"
}

class HelloRepository {
    fun getHello(): String = "Ktor & Koin"
}

data class User(
    val id: Int? = null,
    val name: String,
    val age: Int
)

object Users : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val name: Column<String> = varchar("name", 255)
    val age: Column<Int> = integer("age")

    override val primaryKey = PrimaryKey(id, name = "PK_Users_ID")

    fun toUser(row: ResultRow): User =
        User(
            id = row[id],
            name = row[name],
            age = row[age]
        )
}


fun main(args: Array<String>) {
    startKoin {
        modules(helloAppModule)
    }
    io.ktor.server.netty.EngineMain.main(args)
}



@Suppress("unused")
fun Application.mainModule() {
    val service: HelloService by inject(HelloService::class.java)

    install(ContentNegotiation) {
        gson()
    }

//    Database.connect("jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;", "org.h2.Driver")
//
//    transaction {
//        SchemaUtils.create(bloczek.pl.Users)
//
//        bloczek.pl.Users.insert {
//            it[name] = "John"
//            it[age] = 25
//        }
//
//        bloczek.pl.Users.insert {
//            it[name] = "Marian"
//            it[age] = 15
//        }
//    }

    DatabaseFactory.connectAndMigrate(environment.config)




    routing {
        route("/user") {
            get {
//                val users = transaction { bloczek.pl.Users.selectAll().map { bloczek.pl.Users.toUser(it) } }

                val users = dbQuery {
                    Products.selectAll().map { Products.toProduct(it) }
                }

                call.respond(users)
            }
            post {
                val user = call.receive<User>();
                dbQuery {
                    Users.insert {
                        it[name] = "Marian"
                        it[age] = 15
                    }
                }
                call.respond(user)
            }
        }
    }
}
