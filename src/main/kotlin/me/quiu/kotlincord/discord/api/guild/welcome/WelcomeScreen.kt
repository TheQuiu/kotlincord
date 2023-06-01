package me.quiu.kotlincord.discord.api.guild.welcome

data class WelcomeScreen(
    val description: String?,
    val welcomeChannels: List<WelcomeChannel>
)