package me.quiu.kotlincord.discord.api.guild.role

data class RoleTags(
    val botId: String?,
    val integrationId: String?,
    val premiumSubscriber: Boolean?,
    val subscriptionListingId: String?,
    val availableForPurchase: Boolean?,
    val guildConnections: Boolean?
)