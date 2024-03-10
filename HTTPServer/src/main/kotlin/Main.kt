package de.mw

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {

    val port = 8888
    val serverSocket = ServerSocket(port)

    // simpleTCPEchoServer(serverSocket, port)

    val httpServer = HTTPServer(serverSocket)
    httpServer.start()
}

private fun simpleTCPEchoServer(serverSocket: ServerSocket, port: Int) {
    println("Starting simple TCP echo server!")
    println("Listening on port: $port")

    while (true) {
        val clientSocket = serverSocket.accept()
        println("New connection: ${clientSocket.inetAddress}")

        val input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
        val output = PrintWriter(clientSocket.getOutputStream(), true)

        val clientMessage = input.readLines()
        println("Message form client: $clientMessage")

        output.println(clientMessage)

        clientSocket.close()
    }
}

class HTTPServer(private val serverSocket: ServerSocket) {
    private val crlf = "\r\n"

    private val headersMap = mapOf(
        "Server" to "Mini test server",
        "Content-Type" to "text/html"
    )

    fun start() {
        while (true) {
            val clientSocket = serverSocket.accept()
            println("New connection: ${clientSocket.inetAddress}")

            PrintWriter(clientSocket.getOutputStream(), true).println(handleRequest())

            clientSocket.close()
        }
    }

    private fun handleRequest(): String {
        val responseBody = """
            <html>
            <body>
            <h1>Hello World!</h1>
            <body>
            </html>
        """.trimIndent()

        return buildStatusLine(HttpCode.OK) + prepareHeader(headersMap) + responseBody
    }

    private fun buildStatusLine(status: HttpCode): String = "HTTP/1.1 ${status.code} ${status.name}$crlf"

    private fun prepareHeader(headers: Map<String, String>): String =
        headers.map { "${it.key}: ${it.value}" }.joinToString(crlf).plus(crlf.repeat(2))


    // When implementing the path logic, lets stick to whithelisting(only server allowed/known files)
    // Initilise with cache object/list, when found try to serve success/fail+clean cache
    // When not in cache, refresh cache and try to match
}

class HttpRequest(
    val method: HttpMethod,
    val uri: String,
    val httpVersion: String = "1.1"
) {
    fun parse(inputStream: InputStream): HttpRequest {
        val lines = BufferedReader(InputStreamReader(inputStream)).readLines()

        val requestLineRaw = lines.first().split(" ")

        val httpMethod = HttpMethod.valueOf(requestLineRaw[0])
        // TODO: Can throw an IllegalArgumentException, handle above

        val request = if (requestLineRaw.size > 2) {
            HttpRequest(httpMethod, requestLineRaw[1], requestLineRaw[2])
        } else {
            HttpRequest(httpMethod, requestLineRaw[1])
        }

        return request
    }
}

enum class HttpMethod {
    GET,
    POST,
    UPDATE,
    DELETE
}

enum class HttpCode(val code: Int) {
    OK(200),
    NOT_FOUND(404)
}

