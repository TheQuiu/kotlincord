package me.quiu.kotlincord.discord.api.task.manager

import me.quiu.kotlincord.discord.api.task.Task

interface DiscordTaskManager {
    fun runTask(task: Task)
    fun stopTask(task: Task)
}