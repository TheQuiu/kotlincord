package me.quiu.kotlincord.discord.api

import com.fasterxml.jackson.databind.ObjectMapper
import me.quiu.kotlincord.discord.DiscordApi
import me.quiu.kotlincord.discord.api.guild.loader.GuildLoader
import me.quiu.kotlincord.discord.api.guild.loader.impl.GuildLoaderImpl
import me.quiu.kotlincord.discord.api.member.loader.MemberLoader
import me.quiu.kotlincord.discord.api.member.loader.impl.MemberLoaderImpl
import me.quiu.kotlincord.discord.api.task.manager.DiscordTaskManager
import me.quiu.kotlincord.discord.api.task.manager.impl.DiscordTasksManager
import me.quiu.kotlincord.discord.listener.DiscordWebsocketListener
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocketListener
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import java.io.IOException

@SpringBootApplication
class DiscordApi : DiscordApi {

    private lateinit var guildLoader: GuildLoader
    private lateinit var tasksManager: DiscordTaskManager
    private lateinit var memberLoader: MemberLoader
    private lateinit var discordWebSocketListener: WebSocketListener
    private val httpClient = OkHttpClient()
    private val objectMapper = ObjectMapper()
    private lateinit var token: String
    private lateinit var context: ConfigurableApplicationContext


    override fun login(token: String) {
        this.token = token
        doLogin(token)
    }

    override fun login() {
        doLogin(System.getProperty("token"))
    }

    override fun getToken(): String {
        return this.token.ifEmpty { System.getProperty("token") }
    }

    override fun getTasksManager(): DiscordTaskManager {
        return this.tasksManager
    }

    override fun getMemberLoader(): MemberLoader {
        return this.memberLoader
    }

    override fun getWebSocketListener(): WebSocketListener {
        return this.discordWebSocketListener
    }

    override fun getGuildLoader(): GuildLoader {
        return this.guildLoader
    }

    private fun doLogin(token: String) {
        init()
        val request = Request.Builder()
            .url("https://discord.com/api/v10/gateway/bot")
            .header("Authorization", "Bot $token")
            .build()

        try {
            val response = httpClient.newCall(request).execute()
            if (response.isSuccessful) {
                val responseBody = response.body.string()
                println("Бот успешно подключен: $responseBody")
                startEventLoop(responseBody)
                context = SpringApplication.run(DiscordApi::class.java)
            } else {
                println("Не удалось подключиться к API: ${response.code} ${response.message}")
            }
            response.close()
        } catch (e: IOException) {
            println("Не удалось подключиться к API: ${e.message}")
        }
    }

    private fun startEventLoop(response: String) {
        val gatewayURL = objectMapper.readTree(response).get("url").textValue()
        val request = Request.Builder().url(gatewayURL).build()

        httpClient.newWebSocket(request, this.getWebSocketListener())
    }

    private fun init() {
        if (System.getProperty("token").isEmpty()) System.setProperty("token", this.token)

        this.guildLoader = GuildLoaderImpl()
        this.discordWebSocketListener = DiscordWebsocketListener()
        this.memberLoader = MemberLoaderImpl()
        this.tasksManager = DiscordTasksManager()
    }
}