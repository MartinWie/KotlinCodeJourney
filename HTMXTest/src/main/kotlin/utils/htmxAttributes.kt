package de.mw.utils

import kotlinx.html.HTMLTag
import org.intellij.lang.annotations.Language


/**
 * The hx-get attribute will cause an element to issue a GET to the specified URL
 * and swap the HTML into the DOM using a swap strategy.
 *
 * [Details](https://htmx.org/attributes/hx-get/)
 */
fun HTMLTag.hxGet(path: String) {
    attributes += "hx-get" to path
}

/**
 * The hx-post attribute will cause an element to issue a POST to the specified URL
 * and swap the HTML into the DOM using a swap strategy (HxSwapOption).
 *
 * [Details](https://htmx.org/attributes/hx-post/)
 */
fun HTMLTag.hxPost(path: String) {
    attributes += "hx-post" to path
}

/**
 * The hx-swap attribute allows you to specify how the response will be swapped in relative to the target of an AJAX request.
 * If you do not specify the option (HxSwapOption), the default is htmx.config.defaultSwapStyle (innerHTML).
 *
 * [Details](https://htmx.org/attributes/hx-swap/)
 */
fun HTMLTag.hxSwap(swapOption: HxSwapOption) {
    attributes += "hx-swap" to swapOption.value
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
 * [Details](https://htmx.org/attributes/hx-put/)
 */
fun HTMLTag.hxPut(path: String) {
    attributes += "hx-put" to path
}

/**
 * The hx-delete attribute will cause an element to issue a DELETE to the specified URL
 * and swap the HTML into the DOM using a swap strategy (HxSwapOption).
 *
 * [Details](https://htmx.org/attributes/hx-delete/)
 */
fun HTMLTag.hxDelete(path: String) {
    attributes += "hx-delete" to path
}

/**
 * The hx-patch attribute will cause an element to issue a PATCH to the specified URL
 * and swap the HTML into the DOM using a swap strategy (HxSwapOption).
 *
 * [Details](https://htmx.org/attributes/hx-patch/)
 */
fun HTMLTag.hxPatch(path: String) {
    attributes += "hx-patch" to path
}

/**
 * The hx-on* attributes allow you to embed scripts inline to respond to events directly on an element;
 * Similar to the "onevent" properties found in HTML, such as onClick.
 *
 * [Details](https://htmx.org/attributes/hx-on/)
 */
fun HTMLTag.hxOn(
    event: String,
    @Language("JavaScript")
    jsCode: String
) {
    attributes += "hx-on:$event" to jsCode
}

/**
 * The hx-push-url attribute allows you to push a URL into the browser location history.
 * This creates a new history entry, allowing navigation with the browser’s back and forward buttons.
 * htmx snapshots the current DOM and saves it into its history cache, and restores from this cache on navigation.
 *
 * [Details](https://htmx.org/attributes/hx-push-url/)
 */
fun HTMLTag.hxPushUrl(boolean: Boolean) {
    attributes += "hx-push-url" to "$boolean"
}

/**
 * The hx-push-url attribute allows you to push a URL into the browser location history.
 * This creates a new history entry, allowing navigation with the browser’s back and forward buttons.
 * htmx snapshots the current DOM and saves it into its history cache, and restores from this cache on navigation.
 *
 * [Details](https://htmx.org/attributes/hx-push-url/)
 */
fun HTMLTag.hxPushUrl(path: String) {
    attributes += "hx-push-url" to path
}

/**
 * The hx-select attribute allows you to select the content you want swapped from a response.
 * The value of this attribute is a CSS query selector of the element or elements to select from the response.
 *
 * [Details](https://htmx.org/attributes/hx-select/)
 */
fun HTMLTag.hxSelect(selector: String) {
    attributes += "hx-get" to selector
}