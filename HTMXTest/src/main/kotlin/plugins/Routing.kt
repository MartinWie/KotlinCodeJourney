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
                    hxSwap(HxSwapOption.NONE)

                    input {
                        type = InputType.text
                        name = "todoItem"
                    }

                    button {
                        type = ButtonType.submit
                        +"Add"
                    }
                }

                div {
                    id = "add-todo-error"
                }

                div {
                    id = "todos"

                    tmpTodoState.forEach { element ->
                        p { +element }
                    }
                }
            }

            call.respondText(htmlContent, ContentType.Text.Html)
        }

        post("/add-todo") {
            val userInput = call.receiveParameters()["todoItem"]

            if (userInput.isNullOrEmpty() || tmpTodoState.contains(userInput)) {
                val errorMessage = "Error: Todo is empty or already exists!"
                val errorHtml = buildHTMLString {
                    div {
                        id = "add-todo-error"
                        hxSwapOob()
                        +errorMessage
                    }
                }

                call.respondText(errorHtml, ContentType.Text.Html, HttpStatusCode.UnprocessableEntity)
                return@post
            }

            tmpTodoState.add(userInput)

            val htmlContent = buildHTMLString {
                div {
                    id = "todos"
                    hxSwapOob("afterbegin")
                    p { +userInput }
                }
            }

            call.respondText(htmlContent, ContentType.Text.Html)
        }
    }
}
