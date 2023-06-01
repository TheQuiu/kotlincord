package me.quiu.kotlincord

import me.quiu.kotlincord.discord.api.DiscordApi
import me.quiu.kotlincord.discord.api.guild.loader.GuildLoader


fun main() {
    val api = DiscordApi()
    api.login()
    val memberLoader = api.getMemberLoader()
    val guildLoaderImpl: GuildLoader = api.getGuildLoader()
    println(memberLoader.loadUsersByIds(listOf("802219001383616552", "802219001383616552")))
    println(memberLoader.loadUserById("980525100052922368"))
    println(guildLoaderImpl.loadGuildInfo("911223527313666048"))
}