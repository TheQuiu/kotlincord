package me.quiu.kotlincord.discord.api.guild.role

data class Role(
    val id: String,
    val name: String,
    val color: Int,
    val hoist: Boolean,
    val icon: String?,
    val unicodeEmoji: String?,
    val position: Int,
    val permissions: String,
    val managed: Boolean,
    val mentionable: Boolean,
    val tags: RoleTags?
)
