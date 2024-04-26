package de.mw.utils

@Suppress("unused", "MayBeConstant")
object HtmxExtensions {
    // Includes the commonly-used X-Requested-With header that identifies ajax requests in many backend frameworks.
    val AjaxHeader = "ajax-header"

    // An extension for using the Alpine.js morph plugin as the swapping mechanism in htmx.
    val AlpineMorph = "alpine-morph"

    // An extension for manipulating timed addition and removal of classes on HTML elements.
    val ClassTools = "class-tools"

    // Support for client side template processing of JSON/XML responses.
    val ClientSideTemplates = "client-side-templates"

    // An extension for debugging of a particular element using htmx.
    val Debug = "debug"

    // Includes a JSON serialized version of the triggering event, if any.
    val EventHeader = "event-header"

    // Support for merging the head tag from responses into the existing document's head.
    val HeadSupport = "head-support"

    // Allows you to include additional values in a request.
    val IncludeVals = "include-vals"

    // Use JSON encoding in the body of requests, rather than the default x-www-form-urlencoded.
    val JsonEnc = "json-enc"

    // An extension for using the idiomorph morphing algorithm as a swapping mechanism.
    val Idiomorph = "idiomorph"

    // Allows you to disable inputs, add and remove CSS classes to any element while a request is in-flight.
    val LoadingStates = "loading-states"

    // Use the X-HTTP-Method-Override header for non-GET and POST requests.
    val MethodOverride = "method-override"

    // An extension for using the morphdom library as the swapping mechanism in htmx.
    val MorphdomSwap = "morphdom-swap"

    // Allows to swap multiple elements with different swap methods.
    val MultiSwap = "multi-swap"

    // An extension for expressing path-based dependencies similar to intercooler.js.
    val PathDeps = "path-deps"

    // Preloads selected href and hx-get targets based on rules you control.
    val Preload = "preload"

    // Allows you to remove an element after a given amount of time.
    val RemoveMe = "remove-me"

    // Allows to specify different target elements to be swapped when different HTTP response codes are received.
    val ResponseTargets = "response-targets"

    // Allows you to trigger events when the back button has been pressed.
    val Restored = "restored"

    // Uni-directional server push messaging via EventSource.
    val ServerSentEvents = "server-sent-events"

    // Bi-directional connection to WebSocket servers.
    val WebSockets = "web-sockets"

    // Allows to use parameters for path variables instead of sending them in query or body.
    val PathParams = "path-params"
}
