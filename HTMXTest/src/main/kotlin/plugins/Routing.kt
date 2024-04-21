package de.mw.plugins

import de.mw.utils.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Application.configureRouting() {
    val tmpGlobalState = mutableListOf<String>()

    routing {
        get("/") {
            val htmlContent = htmlBasePage("Todo List") {
                h1 { +"Todo test app" }

                input { id = "todo-input" }

                button {
                    hxPost("/clicked")
                    hxSwap(HxSwapOption.INNER_HTML)
                    hxTarget("#todos")
                    hxVals("js:{'todoItem' : document.getElementById('todo-input').value}")
                    +"Click Me"
                }

                br()

                div {
                    id = "todos"
                    tmpGlobalState.forEach { element ->
                        p { +element }
                    }
                }

                br()
            }

            call.respondText(htmlContent, ContentType.Text.Html)
        }

        post("/clicked") {
            val userInput = call.receiveParameters()["todoItem"]

            userInput?.let {
                tmpGlobalState.add(it)
            }

            val htmlContent = buildHTMLString {
                tmpGlobalState.forEach { element ->
                    p { +element }
                }
            }

            call.respondText(htmlContent, ContentType.Text.Html)
        }
    }
}
