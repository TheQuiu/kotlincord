package me.quiu.kotlincord.discord.api.guild.loader

import me.quiu.kotlincord.discord.api.ban.Ban
import me.quiu.kotlincord.discord.api.guild.Guild

interface GuildLoader {
    fun loadGuildInfo(id: String): Guild
    fun loadGuildsByIds(ids: List<String>): List<Guild>
    fun getGuildBans(id: String): List<Ban>

}