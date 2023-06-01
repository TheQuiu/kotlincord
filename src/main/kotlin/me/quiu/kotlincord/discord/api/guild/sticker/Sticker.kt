package me.quiu.kotlincord.discord.api.guild.sticker

import me.quiu.kotlincord.discord.api.member.type.Member

data class Sticker(
    val id: String,
    val packId: String?,
    val name: String,
    val description: String?,
    val tags: String,
    val asset: String?,
    val type: Int,
    val formatType: Int,
    val available: Boolean?,
    val guildId: String?,
    val user: Member?,
    val sortValue: Int?
)