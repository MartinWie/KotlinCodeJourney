package de.mw.plugins

import de.mw.utils.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun Application.configureRouting() {
    val tmpGlobalState = mutableListOf<String>()
    tmpGlobalState.add("0")

    routing {
        get("/") {
            val htmlContent = htmlBasePage("Todo List") {
                h1 { +"Todo test app" }

                button {
                    hxPost("/clicked")
                    hxSwap(HxSwapOption.INNER_HTML)
                    hxTarget(".todos")
                    +"Click Me"
                }

                br()

                div {
                    classes = setOf("todos")
                    tmpGlobalState.forEach { element ->
                        p { +element }
                    }
                }

                br()
            }

            call.respondText(htmlContent, ContentType.Text.Html)
        }

        post("/clicked") {
            tmpGlobalState.add(tmpGlobalState.size.toString())
            val htmlContent = createHTML().html {
                body {
                    tmpGlobalState.forEach { element ->
                        p { +element }
                    }
                }
            }
            call.respondText(htmlContent, ContentType.Text.Html)
        }
    }
}
