package me.quiu.kotlincord.discord.api.role

data class RoleTags(
    val botId: String?,
    val integrationId: String?,
    val premiumSubscriber: Boolean?,
    val subscriptionListingId: String?,
    val availableForPurchase: Boolean?,
    val guildConnections: Boolean?
)