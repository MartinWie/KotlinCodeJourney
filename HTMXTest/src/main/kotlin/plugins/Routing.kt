package de.mw.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun Application.configureRouting() {
    routing {
        get("/") {
            val htmlContent = "<!DOCTYPE html>" + createHTML().html {
                head {
                    title = "My Web Page"
                    script { src = "https://unpkg.com/htmx.org@1.9.11" }
                }
                body {
                    h1 { +"Welcome to my first htmx page!" }
                    p { +"Wow much p tag :D" }
                    button {
                        attributes["hx-post"] = "/clicked"
                        attributes["hx-swap"] = "outerHTML"
                        +"Click Me"
                    }
                }
            }

            call.respondText(htmlContent, ContentType.Text.Html)
        }

        post("/clicked") {
            val htmlContent = "Test"
            call.respondText(htmlContent, ContentType.Text.Html)
        }
    }
}
