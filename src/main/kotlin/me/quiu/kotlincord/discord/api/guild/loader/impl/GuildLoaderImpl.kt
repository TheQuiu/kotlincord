package me.quiu.kotlincord.discord.api.guild.loader.impl

import com.google.gson.Gson
import me.quiu.kotlincord.discord.api.ban.Ban
import me.quiu.kotlincord.discord.api.guild.Guild
import me.quiu.kotlincord.discord.api.guild.loader.GuildLoader
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class GuildLoaderImpl: GuildLoader {
    private val httpClient = OkHttpClient()
    private val discordApiUrl: String = "https://discord.com/api/v10/guilds/"
    private val requestBuilder: Request.Builder = Request.Builder()
            .header("Authorization", "Bot ${System.getProperty("token")}")
            .get()
    private val gson: Gson = Gson()
    override fun loadGuildInfo(id: String): Guild? {
        val response: Response = httpClient.newCall(requestBuilder.url(discordApiUrl+id).build()).execute()
        val body = response.body.string()
        return gson.fromJson(body, Guild::class.java)
    }

    override fun loadGuildsByIds(ids: List<String>): List<Guild> {
        TODO("Not yet implemented")
    }

    override fun getGuildBans(id: String): List<Ban> {
        TODO("Not yet implemented")
    }
}