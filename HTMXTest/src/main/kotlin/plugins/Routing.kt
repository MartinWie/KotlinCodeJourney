package de.mw.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            val htmlContent = """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>My Web Page</title>
                </head>
                <body>
                    <h1>Welcome to Ktor!</h1>
                    <p>This is an example of serving HTML with Ktor.</p>
                </body>
                </html>
            """.trimIndent()

            call.respondText(htmlContent, ContentType.Text.Html)
        }
    }
}
