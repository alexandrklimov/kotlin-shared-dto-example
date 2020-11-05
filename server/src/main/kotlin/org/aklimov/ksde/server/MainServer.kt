package org.aklimov.ksde.server

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.util.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

import org.aklimov.ksde.shared.TestDto

fun main(){
    val server = embeddedServer(Netty, 8082) {
        install(CORS){
            anyHost()
        }

        routing {
            route("/api"){
                get("/echo") {
                    val respDto = TestDto(call.parameters.getOrFail("message"))
                    call.respondText(
                        Json.encodeToString(respDto),
                        ContentType.Application.Json
                    )
                }
            }
        }
    }
    server.start(wait = true)
}
