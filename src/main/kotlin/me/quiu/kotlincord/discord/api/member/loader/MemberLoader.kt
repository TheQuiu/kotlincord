package me.quiu.kotlincord.discord.api.member.loader

import me.quiu.kotlincord.discord.api.member.type.Member

interface MemberLoader {
    fun loadUserById(id: String): Member
    fun loadUsersByIds(ids: List<String>): List<Member>
}