package de.mw.plugins

import de.mw.utils.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Application.configureRouting() {
    val tmpTodoState = mutableListOf<String>()

    routing {
        get("/") {
            val htmlContent = htmlBasePage("Todo List") {
                h1 { +"Todo test app" }

                form {
                    hxPost("/add-todo")
                    hxSwap(HxSwapOption.INNER_HTML)
                    hxTarget("#todos")

                    input {
                        type = InputType.text
                        name = "todoItem"
                    }

                    button {
                        type = ButtonType.submit
                        +"Add"
                    }
                }

                br()

                div {
                    id = "todos"
                    tmpTodoState.forEach { element ->
                        p { +element }
                    }
                }

                br()
            }

            call.respondText(htmlContent, ContentType.Text.Html)
        }

        post("/add-todo") {
            val userInput = call.receiveParameters()["todoItem"]

            if (userInput.isNullOrEmpty() || tmpTodoState.contains(userInput)) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            userInput.let {
                tmpTodoState.add(it)
            }

            val htmlContent = buildHTMLString {
                tmpTodoState.forEach { element ->
                    p { +element }
                }
            }

            call.respondText(htmlContent, ContentType.Text.Html)
        }
    }
}
