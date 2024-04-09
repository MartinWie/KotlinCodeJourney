package de.mw.plugins

import de.mw.utils.HxSwapOption
import de.mw.utils.htmlBasePage
import de.mw.utils.hxPost
import de.mw.utils.hxSwap
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.button
import kotlinx.html.h1
import kotlinx.html.p

fun Application.configureRouting() {
    routing {
        get("/") {
            val htmlContent = htmlBasePage("Test123") {
                h1 { +"Welcome to my first htmx page!" }
                p { +"Wow much p tag :D" }
                button {
                    hxPost("/clicked")
                    hxSwap(HxSwapOption.OUTER_HTML.value)
                    +"Click Me"
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
