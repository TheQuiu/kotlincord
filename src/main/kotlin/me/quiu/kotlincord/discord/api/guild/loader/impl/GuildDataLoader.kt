package me.quiu.kotlincord.discord.api.guild.loader.impl

import me.quiu.kotlincord.discord.api.ban.Ban
import me.quiu.kotlincord.discord.api.guild.Guild
import me.quiu.kotlincord.discord.api.guild.loader.GuildLoader

class GuildDataLoader: GuildLoader {
    override fun loadGuildInfo(id: String): Guild {
        TODO("Not yet implemented")
    }

    override fun loadGuildsByIds(ids: List<String>): List<Guild> {
        TODO("Not yet implemented")
    }

    override fun getGuildBans(id: String): List<Ban> {
        TODO("Not yet implemented")
    }
}