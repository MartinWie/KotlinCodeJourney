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
                    id = "todo-form"
                    hxPost("/add-todo")
                    hxSwap(HxSwapOption.NONE)
                    hxOn(
                        "after-request",
                        "if(event.detail.successful) this.reset()"
                    ) // TODO: move into reusable function(hxClear form or extension of FORM)

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
                    id = "todo-input-error"
                }

                div {
                    id = "todos"

                    tmpTodoState.reversed().forEach { element ->
                        p { +element }
                    }
                }
            }

            call.respondText(htmlContent, ContentType.Text.Html)
        }

        post("/add-todo") {
            val userInput = call.receiveParameters()["todoItem"]

            if (userInput.isNullOrEmpty() || tmpTodoState.contains(userInput)) {
                call.response.header( // TODO: clean up and add HTMX headers to utils
                    "HX-Retarget",
                    "#todo-input-error"
                )
                call.response.header(
                    "HX-Reswap",
                    HxSwapOption.INNER_HTML.name
                )
                val errorMessage = "Error: Todo is empty or already exists!"

                call.respondText(errorMessage, ContentType.Text.Html, HttpStatusCode.UnprocessableEntity)
                return@post
            }

            tmpTodoState.add(userInput)

            val htmlContent = buildHTMLString {
                div {
                    id = "todos"
                    hxSwapOob("afterbegin")
                    p { +userInput }
                }

                div {
                    id = "todo-input-error"
                    hxSwapOob()
                }

            }

            call.respondText(htmlContent, ContentType.Text.Html)
        }
    }
}
