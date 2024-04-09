package de.mw

import de.mw.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
}


/* Project todos:
    - implement HTMX constants and extension functions
    - Implement simple todolist page
    - Add tailwind
    - Look into jOOQ ?
    - prep HTMX todolist repo
    - prep HTMX + Kotlin + Ktor Template repo
 */