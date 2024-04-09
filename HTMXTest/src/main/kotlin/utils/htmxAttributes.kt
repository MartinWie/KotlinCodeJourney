package de.mw.utils

import kotlinx.html.HTMLTag

/**
 * The hx-post attribute will cause an element to issue a POST to the specified URL
 * and swap the HTML into the DOM using a swap strategy.
 *
 * https://htmx.org/attributes/hx-post/
 */
fun HTMLTag.hxPost(value: String) {
    attributes += "hx-post" to value
}

/**
 * The hx-swap attribute allows you to specify how the response will be swapped in relative to the target of an AJAX request.
 * If you do not specify the option, the default is htmx.config.defaultSwapStyle (innerHTML).
 *
 * https://htmx.org/attributes/hx-swap/
 */
fun HTMLTag.hxSwap(value: String) {
    attributes += "hx-swap" to value
}

enum class HxSwapOption(val value: String) {
    INNER_HTML("innerHTML"),
    OUTER_HTML("outerHTML"),
    BEFORE_BEGIN("beforebegin"),
    AFTER_BEGIN("afterbegin"),
    BEFORE_END("beforeend"),
    AFTER_END("afterend"),
    DELETE("delete"),
    NONE("none")
}