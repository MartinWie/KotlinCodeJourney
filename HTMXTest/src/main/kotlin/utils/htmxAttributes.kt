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

/**
 * The hx-swap-oob attribute allows you to specify that some content in a response should be swapped into the DOM
 * somewhere other than the target, that is “Out of Band”.
 * This allows you to piggy back updates to other element updates on a response.
 *
 * TLDR: If hx-swap-oob is set to a boolean value in a server response,
 * it can trigger an update of a specific element on the page that shares the same ID as the response element.
 *
 * [Details](https://htmx.org/attributes/hx-swap-oob/)
 */
fun HTMLTag.hxSwapOob(enabled: Boolean = true) {
    attributes += "hx-swap-oob" to "$enabled"
}

/**
 * The hx-swap-oob attribute allows you to specify that some content in a response should be swapped into the DOM
 * somewhere other than the target, that is “Out of Band”.
 * This allows you to piggy back updates to other element updates on a response.
 *
 * TLDR: If set, a server response containing the corresponding selector can update elements marked with hx-swap-oob,
 * allowing for simultaneous, targeted updates on the page.
 *
 * [Details](https://htmx.org/attributes/hx-swap-oob/)
 */
fun HTMLTag.hxSwapOob(swapOption: HxSwapOption, selector: String? = null) {
    attributes += "hx-swap-oob" to swapOption.value + selector?.let { ":$it" }
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
    attributes += "hx-select" to selector
}

/**
 * The hx-select-oob attribute allows you to select content from a response to be swapped in via an out-of-band swap.
 * The value of this attribute is comma separated list of elements to be swapped out of band.
 * This attribute is almost always paired with hx-select.
 *
 * TLDR: If hx-select-oob is used in a server response, it enables the selection and manipulation of specific elements
 * in the current page DOM, based on matching criteria, for dynamic content updates.
 *
 * [Details](https://htmx.org/attributes/hx-select-oob/)
 */
fun HTMLTag.hxSelectOob(selector: String) {
    attributes += "hx-select-oob" to selector
}


/**
 * Defines the `hx-target` attribute used to specify the target element for content swapping in AJAX responses.
 * This attribute can accept various values to determine the target element:
 *
 * - A CSS query selector specifying the exact element to target.
 * - `this` to indicate that the element with the `hx-target` attribute is the target.
 * - `closest <CSS selector>` to find the nearest ancestor (or the element itself) matching the specified selector.
 *   For example, `closest tr` targets the nearest table row.
 * - `find <CSS selector>` to locate the first child descendant that matches the specified selector.
 * - `next` which targets the element immediately following the current one in the DOM.
 * - `next <CSS selector>` to find the next element in the DOM that matches the specified selector.
 *   For example, `next .error` would target the next sibling with the `error` class.
 * - `previous` which targets the element immediately preceding the current one in the DOM.
 * - `previous <CSS selector>` to find the previous element in the DOM that matches the specified selector.
 *   For example, `previous .error` would target the previous sibling with the `error` class.
 *
 * [Details](https://htmx.org/attributes/hx-target/)
 */
fun HTMLTag.hxTarget(selector: String) {
    attributes += "hx-target" to selector
}

/**
 * The hx-vals attribute allows you to add to the parameters that will be submitted with an AJAX request.
 *
 * By default, the value of this attribute is a list of name-expression values in JSON format.
 *
 * If you wish for hx-vals to evaluate the values given, you can prefix the values with javascript: or js:
 *
 * Security Considerations
 * By default, the value of hx-vals must be valid JSON.
 * It is not dynamically computed. If you use the "javascript:" prefix, be aware that you are introducing
 * security considerations, especially when dealing with user input such as query strings or user-generated
 * content, which could introduce a Cross-Site Scripting (XSS) vulnerability.
 *
 *
 * [Details](https://htmx.org/attributes/hx-vals/)
 */
fun HTMLTag.hxVals(json: String) {
    attributes += "hx-vals" to json
}

/**
 * The hx-disable attribute will disable htmx processing for a given element and all its children.
 * This can be useful as a backup for HTML escaping, when you include user generated content in your site,
 * and you want to prevent malicious scripting attacks.
 *
 * The value of the tag is ignored, and it cannot be reversed by any content beneath it.
 *
 * [Details](https://htmx.org/attributes/hx-disable/)
 */
fun HTMLTag.hxDisable() {
    attributes += "hx-disable" to "true"
}

/**
 * The hx-disabled-elt attribute allows you to specify elements
 * that will have the disabled attribute added to them for the duration of the request.
 *
 * The value of this attribute is a CSS query selector of the element or elements to apply the class to,
 * or the keyword closest, followed by a CSS selector, which will find the closest ancestor element or itself,
 * that matches the given CSS selector (e.g. "closest tr"), or the keyword "this".
 *
 * [Details](https://htmx.org/attributes/hx-disabled-elt/)
 */
fun HTMLTag.hxDisabled(selector: String = "this") {
    attributes += "hx-disabled-elt" to selector
}
