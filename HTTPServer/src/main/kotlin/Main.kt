package de.mw

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    println("Starting simple TCP server!")

    val port = 8888

    val serverSocket = ServerSocket(port)
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