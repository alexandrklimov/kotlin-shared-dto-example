package org.aklimov.ksde.client

import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.aklimov.ksde.shared.TestDto

fun main() {
    window.addEventListener("load", {

        with(requireNotNull(document.body)) {
            append {
                div {
                    id = "panel"

                    button {
                        +"Test Dto"
                        title = "Test DTO"
                        onClickFunction = { _ ->
                            GlobalScope.launch {
                                HttpClient(Js) {
                                    install(JsonFeature) {
                                        serializer = KotlinxSerializer()
                                    }
                                }.use { client ->
                                    val resp = client.get<TestDto>("//localhost:8082/api/echo?message=ololo11")
                                    document.getElementById("panel")?.append {
                                        div { +"Response message: ${resp.message}" }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    })
}

