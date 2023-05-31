package me.quiu.kotlincord.discord.tasks

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.quiu.kotlincord.discord.api.task.Task
import okhttp3.WebSocket


class HeartBeat(
    private val webSocket: WebSocket
) : Task {
    private lateinit var job: Job
    override fun run() {
        val heartbeatInterval = 41250
        job = GlobalScope.launch {
            while (true) {
                delay(heartbeatInterval.toLong())
                webSocket.send("{\"op\": 1, \"d\": null}")
                println("Sending HeartBeat to discord...")
            }
        }
    }

    override fun stop() {
        job.cancel()
    }
}