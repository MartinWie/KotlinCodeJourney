package de.mw.utils

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import kotlinx.html.stream.createHTML

fun htmlBasePage(pageTitle: String, bodyFunction: BODY.() -> Unit): String {
    return "<!DOCTYPE html>" + createHTML().html {
        head {
            title = pageTitle
            script { src = "https://unpkg.com/htmx.org@1.9.11" }
            script(type = ScriptType.textJavaScript) {
                // Using raw strings (triple quotes) to insert multiline JavaScript.
                // The .trimIndent() function is called to ensure that the indentation
                // within the Kotlin source does not affect the indentation in the output text,
                // making it look cleaner in the generated HTML.
                unsafe {
                    // Using unsafe{}.raw() to insert raw HTML/JS.
                    // Be cautious with 'unsafe' as it can potentially open up for XSS vulnerabilities
                    // if untrusted user input is inserted into the HTML.
                    raw(
                        """
            document.addEventListener("DOMContentLoaded", (event) => {
                document.body.addEventListener('htmx:beforeSwap', function(evt) {
                    if (evt.detail.xhr.status === 422) {
                        console.log("setting status to paint");
                        // allow 422 responses to swap as we are using this as a signal that
                        // a form was submitted with bad data and want to rerender with the errors
                        //
                        // set isError to false to avoid error logging in console
                        evt.detail.shouldSwap = true;
                        evt.detail.isError = false;
                    }
                });
            });
        """.trimIndent()
                    )
                }
            }

        }
        body {
            bodyFunction()
        }
    }
}

fun buildHTMLString(builderAction: TagConsumer<StringBuilder>.() -> Unit): String {
    return buildString {
        appendHTML().builderAction()
    }
}
