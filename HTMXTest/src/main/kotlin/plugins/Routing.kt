package de.mw.plugins

import de.mw.utils.buildHTMLString
import de.mw.utils.getTodoForm
import de.mw.utils.htmlBasePage
import de.mw.utils.hxSwapOob
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.id
import kotlinx.html.p

fun Application.configureRouting() {
    val tmpTodoState = mutableListOf<String>()

    routing {
        get("/") {
            val htmlContent = htmlBasePage("Todo List") {
                h1 { +"Todo test app" }

                div {
                    getTodoForm()
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
                val errorMessage = "Error: Todo is empty or already exists!"
                val errorHtml = buildHTMLString {
                    div {
                        getTodoForm(errorMessage)
                    }
                }

                call.respondText(errorHtml, ContentType.Text.Html, HttpStatusCode.UnprocessableEntity)
                return@post
            }

            tmpTodoState.add(userInput)

            val htmlContent = buildHTMLString {
                div {
                    getTodoForm()
                }

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
