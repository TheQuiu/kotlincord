package me.quiu.kotlincord.discord.api.member.loader.impl

import com.google.gson.Gson
import me.quiu.kotlincord.discord.api.member.type.Member
import me.quiu.kotlincord.discord.api.member.loader.MemberLoader
import okhttp3.OkHttpClient
import okhttp3.Request

class MemberLoaderImpl : MemberLoader {

    private val gson = Gson()
    private val httpClient = OkHttpClient()
    private val usersUrl = "https://discord.com/api/v10/users/"
    private val request: Request.Builder = Request.Builder()
        .get()
        .header("Authorization", "Bot ${System.getProperty("token")}")

    override fun loadUserById(id: String): Member {
        val response = httpClient.newCall(
            request
                .url(usersUrl + id)
                .build()
        ).execute()
        return gson.fromJson(response.body.string(), Member::class.java)
    }

    override fun loadUsersByIds(ids: List<String>): List<Member> {
        var result: ArrayList<Member> = ArrayList()
        for (id in ids){
            val response = httpClient.newCall(
                request
                    .url(usersUrl + id)
                    .build()
            ).execute()
            result.add(gson.fromJson(response.body.string(), Member::class.java))
        }
        return result
    }

}