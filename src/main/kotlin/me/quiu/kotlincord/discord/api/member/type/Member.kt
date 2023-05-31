package me.quiu.kotlincord.discord.api.member.type

data class Member(
    val id: String,
    val username: String,
    val discriminator: String,
    val avatar: String?,
    val bot: Boolean?,
    val system: Boolean?,
    val mfaEnabled: Boolean?,
    val banner: String?,
    val accentColor: Int?,
    val locale: String?,
    val verified: Boolean?,
    val email: String?,
    val flags: Int?,
    val premiumType: Int?,
    val publicFlags: Int?
)

