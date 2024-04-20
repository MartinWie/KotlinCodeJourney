package de.mw.utils

import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun htmlBasePage(pageTitle: String, bodyFunction: BODY.() -> Unit): String {
    return "<!DOCTYPE html>" + createHTML().html {
        head {
            title = pageTitle
            script { src = "https://unpkg.com/htmx.org@1.9.11" }
        }
        body {
            bodyFunction()
        }
    }
}