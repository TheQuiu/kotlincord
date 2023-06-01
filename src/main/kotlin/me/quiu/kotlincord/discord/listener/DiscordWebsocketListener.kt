package me.quiu.kotlincord.discord.listener

import me.quiu.kotlincord.discord.api.task.manager.DiscordTaskManager
import me.quiu.kotlincord.discord.api.task.manager.impl.DiscordTasksManager
import me.quiu.kotlincord.discord.tasks.HeartBeat
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener


class DiscordWebsocketListener : WebSocketListener() {

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        println("Closing connection with discord gateway... with reason: " + reason)
    }

    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        println("Discord gateway connection stopped")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        println(t.stackTrace)
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        println(text)
    }

    override fun onOpen(webSocket: WebSocket, response: Response) {
        println("Connected to discord websocket...")
        val taskManagerI: DiscordTaskManager = DiscordTasksManager()
        taskManagerI.runTask(HeartBeat(webSocket))
        makeIdentify(webSocket)
    }

    private fun makeIdentify(webSocket: WebSocket) {
        val identifyJson = """
                            {
                              "op": 2,
                              "d": {
                                "token": "${System.getProperty("token")}",
                                "intents": 513,
                                "properties": {
                                  "os": "${System.getProperty("os.name")}",
                                  "browser": "KotlinCord",
                                  "device": "PC"
                                }
                              }
                            }
                        """.trimIndent()
        webSocket.send(identifyJson)
    }


}