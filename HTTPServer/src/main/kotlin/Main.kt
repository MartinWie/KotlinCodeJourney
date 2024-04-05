package de.mw

import java.io.*
import java.net.ServerSocket
import java.net.Socket

fun main() {
    val port = 8888
    val serverSocket = ServerSocket(port)
    val httpServer = HTTPServer(serverSocket)

    httpServer.start()
}

class HTTPServer(private val serverSocket: ServerSocket) {
    private val crlf = "\r\n"
    var cachedFiles = getAvailableFiles()

    private val headersMap = mapOf(
        "Server" to "Mini test server",
        "Content-Type" to "text/html"
    )

    fun start() {
        while (true) {
            serverSocket.accept().use { clientSocket ->

                println("New connection: ${clientSocket.inetAddress}")

                val response = handleRequest(clientSocket)

                PrintWriter(clientSocket.getOutputStream(), true).println(response)
            }
        }
    }

    private fun handleRequest(clientSocket: Socket): String {
        val request: HttpRequest

        try {
            request = HttpRequest.parse(clientSocket.getInputStream())
        } catch (e: Exception) {
            return buildStatusLine(HttpCode.INTERNAL_SERVER_ERROR) + prepareHeader(emptyMap()) + e.message
        }

        return when (request.method) {
            HttpMethod.GET -> {
                val requestedFile = request.uri.removePrefix("/")

                // Refresh cache if file was not found
                if (!cachedFiles.any { it.name == requestedFile }) cachedFiles = getAvailableFiles()

                val response = cachedFiles.firstOrNull {
                    it.name == requestedFile
                }?.bufferedReader()?.readLines()?.joinToString(crlf)

                if (response != null) {
                    buildStatusLine(HttpCode.OK) + prepareHeader(headersMap) + response
                } else {
                    buildStatusLine(HttpCode.NOT_FOUND) + prepareHeader(headersMap)
                }

            }

            else -> {
                buildStatusLine(HttpCode.NOT_IMPLEMENTED) + prepareHeader(emptyMap())
            }
        }
    }

    private fun buildStatusLine(status: HttpCode): String = "HTTP/1.1 ${status.code} ${status.name}$crlf"

    private fun prepareHeader(headers: Map<String, String>): String =
        headers.map { "${it.key}: ${it.value}" }.joinToString(crlf).plus(crlf.repeat(2))

    private fun getAvailableFiles(): Array<File> {
        val currentDir = File("./HTTPServer/files/")
        val filesWithPath = currentDir.listFiles() ?: emptyArray()
        return filesWithPath
    }

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

