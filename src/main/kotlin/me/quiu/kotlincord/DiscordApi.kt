package me.quiu.kotlincord

import me.quiu.kotlincord.discord.api.DiscordApi


fun main() {
    val api = DiscordApi()
    api.login()
    val memberLoader = api.getMemberLoader()
    println(memberLoader.loadUsersByIds(listOf("802219001383616552", "802219001383616552")))
    println(memberLoader.loadUserById("980525100052922368"))
}