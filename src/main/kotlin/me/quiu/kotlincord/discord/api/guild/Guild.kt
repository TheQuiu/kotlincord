package me.quiu.kotlincord.discord.api.guild

import com.fasterxml.jackson.annotation.JsonFormat.Features
import me.quiu.kotlincord.discord.api.guild.emoji.Emoji
import me.quiu.kotlincord.discord.api.guild.fatures.GuildFeature
import me.quiu.kotlincord.discord.api.guild.role.Role
import me.quiu.kotlincord.discord.api.guild.sticker.Sticker
import me.quiu.kotlincord.discord.api.guild.welcome.WelcomeScreen


data class Guild(
        val id: String,
        val name: String,
        val icon: String?,
        val iconHash: String?,
        val splash: String?,
        val discoverySplash: String?,
        val owner: Boolean?,
        val ownerId: String,
        val permissions: String?,
        val region: String?,
        val afkChannelId: String?,
        val afkTimeout: Int,
        val widgetEnabled: Boolean?,
        val widgetChannelId: String?,
        val verificationLevel: Int,
        val defaultMessageNotifications: Int,
        val explicitContentFilter: Int,
        val roles: List<Role>,
        val emojis: List<Emoji>,
        val features: List<GuildFeature>,
        val mfaLevel: Int,
        val applicationId: String?,
        val systemChannelId: String?,
        val systemChannelFlags: Int,
        val rulesChannelId: String?,
        val maxPresences: Int?,
        val maxMembers: Int,
        val vanityUrlCode: String?,
        val description: String?,
        val banner: String?,
        val premiumTier: Int,
        val premiumSubscriptionCount: Int?,
        val preferredLocale: String,
        val publicUpdatesChannelId: String?,
        val maxVideoChannelUsers: Int?,
        val maxStageVideoChannelUsers: Int?,
        val approximateMemberCount: Int?,
        val approximatePresenceCount: Int?,
        val welcomeScreen: WelcomeScreen?,
        val nsfwLevel: Int,
        val stickers: List<Sticker>?,
        val premiumProgressBarEnabled: Boolean,
        val safetyAlertsChannelId: String?
)

