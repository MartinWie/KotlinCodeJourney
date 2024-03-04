package de.mw

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {

    val port = 8888
    val serverSocket = ServerSocket(port)

    simpleTCPEchoServer(serverSocket, port)
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