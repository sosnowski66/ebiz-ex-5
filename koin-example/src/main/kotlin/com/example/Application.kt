package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject


fun main() {
    startKoin {
        modules(helloAppModule)
    }

    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
        main()


    }.start(wait = true)
}

fun Application.main() {
    val service: HelloService by inject(HelloService::class.java)

    routing {
        get("/koin") {
            call.respondText(service.sayHello())
        }
    }
}

