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
    - Add tailwind enum or extension setup
    - prep HTMX todolist repo
    - prep HTMX + Kotlin + Ktor Template repo
    - Get HTMX into project instead of using unpkg
    - Get tailwind into project instead of using cdn
    - Make use of html templates instead of fully utilizing kotlin dsl to safe CPU on constructing the page every time
    (rapid prototyping vs efficient production application) (ftr a string builder is probably not horrible for now)
 */