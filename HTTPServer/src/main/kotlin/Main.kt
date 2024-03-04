package de.mw

import java.io.BufferedReader
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

class HTTPServer(val serverSocket: ServerSocket) {
    private val crlf = "\r\n"

    private val headers = listOf(
        "Server: Mini test server",
        "Content-Type: text/html"
    ).joinToString(crlf) { it }.plus(crlf)

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

        return buildStatusLine(HttpCode.OK) + headers + crlf + responseBody
    }

    private fun buildStatusLine(status: HttpCode): String = "HTTP/1.1 ${status.code} ${status.name}$crlf"

}

enum class HttpCode(val code: Int) {
    OK(200),
    NOT_FOUND(404)
}

