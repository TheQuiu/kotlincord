package me.quiu.kotlincord.discord

import me.quiu.kotlincord.discord.api.guild.loader.GuildLoader
import me.quiu.kotlincord.discord.api.member.loader.MemberLoader
import me.quiu.kotlincord.discord.api.task.manager.DiscordTaskManager
import okhttp3.WebSocketListener

interface DiscordApi {
    fun login(token: String) //Login with token
    fun login() //Login with token from system property {System.getProperty("token")}
    fun getToken(): String
    fun getTasksManager(): DiscordTaskManager
    fun getMemberLoader(): MemberLoader
    fun getWebSocketListener(): WebSocketListener
    fun getGuildLoader(): GuildLoader
}