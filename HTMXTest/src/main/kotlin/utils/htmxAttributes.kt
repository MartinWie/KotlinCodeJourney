package de.mw.utils

import kotlinx.html.HTMLTag


/**
 * The hx-get attribute will cause an element to issue a GET to the specified URL
 * and swap the HTML into the DOM using a swap strategy.
 *
 * https://htmx.org/attributes/hx-get/
 */
fun HTMLTag.hxGet(path: String) {
    attributes += "hx-get" to path
}

/**
 * The hx-post attribute will cause an element to issue a POST to the specified URL
 * and swap the HTML into the DOM using a swap strategy (HxSwapOption).
 *
 * https://htmx.org/attributes/hx-post/
 */
fun HTMLTag.hxPost(path: String) {
    attributes += "hx-post" to path
}

/**
 * The hx-swap attribute allows you to specify how the response will be swapped in relative to the target of an AJAX request.
 * If you do not specify the option (HxSwapOption), the default is htmx.config.defaultSwapStyle (innerHTML).
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

/**
 * The hx-put attribute will cause an element to issue a PUT to the specified URL
 * and swap the HTML into the DOM using a swap strategy (HxSwapOption).
 *
 * https://htmx.org/attributes/hx-put/
 */
fun HTMLTag.hxPut(path: String) {
    attributes += "hx-put" to path
}

/**
 * The hx-delete attribute will cause an element to issue a DELETE to the specified URL
 * and swap the HTML into the DOM using a swap strategy (HxSwapOption).
 *
 * https://htmx.org/attributes/hx-delete/
 */
fun HTMLTag.hxDelete(path: String) {
    attributes += "hx-delete" to path
}