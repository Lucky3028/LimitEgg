package com.github.lucky3028.limitegg

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor

class ToggleCommand : TabExecutor {
    override fun onTabComplete(p0: CommandSender?, p1: Command?, p2: String?, p3: Array<out String>?): MutableList<String> {
        return mutableListOf()
    }

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        return true
    }
}