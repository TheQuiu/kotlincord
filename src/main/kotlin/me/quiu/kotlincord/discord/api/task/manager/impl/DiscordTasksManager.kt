package me.quiu.kotlincord.discord.api.task.manager.impl

import me.quiu.kotlincord.discord.api.task.Task
import me.quiu.kotlincord.discord.api.task.manager.DiscordTaskManager

class DiscordTasksManager : DiscordTaskManager {

    override fun runTask(task: Task) {
        task.run()
    }

    override fun stopTask(task: Task) {
        task.stop()
    }
}