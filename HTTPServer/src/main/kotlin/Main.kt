package de.mw

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

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

            val text = handleRequest(clientSocket)

            PrintWriter(clientSocket.getOutputStream(), true).println(text)

            clientSocket.close()
        }
    }

    private fun handleRequest(clientSocket: Socket): String {

        val request: HttpRequest

        try {
            request = HttpRequest.parse(clientSocket.getInputStream())
        } catch (e: Exception) {
            return buildStatusLine(HttpCode.INTERNAL_SERVER_ERROR) + prepareHeader(emptyMap()) + e.message
        }

        val responseBody = request.method

        return buildStatusLine(HttpCode.OK) + prepareHeader(headersMap) + responseBody
    }

    private fun buildStatusLine(status: HttpCode): String = "HTTP/1.1 ${status.code} ${status.name}$crlf"

    private fun prepareHeader(headers: Map<String, String>): String =
        headers.map { "${it.key}: ${it.value}" }.joinToString(crlf).plus(crlf.repeat(2))

}

class HttpRequest(
    val method: HttpMethod,
    val uri: String,
    val httpVersion: String = "1.1"
) {
    companion object {
        fun parse(inputStream: InputStream): HttpRequest {
            val reader = BufferedReader(InputStreamReader(inputStream))

            var currentLine: String? = reader.readLine()

            val requestLineRaw = currentLine!!.split(" ")
            val httpMethod = HttpMethod.valueOf(requestLineRaw[0])

            val headers = mutableMapOf<String, String>()

            currentLine = reader.readLine()
            while (!currentLine.isNullOrBlank()) {

                val headerLineSplitt = currentLine.split(": ")
                headers[headerLineSplitt[0]] = headerLineSplitt[1]
                currentLine = reader.readLine()
            }

            return if (requestLineRaw.size > 2) {
                HttpRequest(httpMethod, requestLineRaw[1], requestLineRaw[2])
            } else {
                HttpRequest(httpMethod, requestLineRaw[1])
            }
        }
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
    NOT_FOUND(404),
    NOT_IMPLEMENTED(501),
    INTERNAL_SERVER_ERROR(500)
}

