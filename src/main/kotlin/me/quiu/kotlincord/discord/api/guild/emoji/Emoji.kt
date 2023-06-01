package me.quiu.kotlincord.discord.api.guild.emoji

import me.quiu.kotlincord.discord.api.member.type.Member

data class Emoji(
    val id: String?,
    val name: String?,
    val roles: List<String>?,
    val user: Member?,
    val requireColons: Boolean?,
    val managed: Boolean?,
    val animated: Boolean?,
    val available: Boolean?
)