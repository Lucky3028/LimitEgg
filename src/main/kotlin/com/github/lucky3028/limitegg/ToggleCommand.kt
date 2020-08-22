package com.github.lucky3028.limitegg

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ToggleCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("${ChatColor.RED}プレイヤーのみ使用できるコマンドです。")
            return false
        }

        if (args.isNotEmpty() && args[0] == "toggle") {
            if (sender.hasPermission("limitegg.ignoretoggle")) {
                IgnoreFlag.toggleIgnoreFlag(sender)
            } else {
                sender.sendMessage("${ChatColor.RED}このコマンドを実行する権限がありません。")
            }
        } else {
            sender.sendMessage("${ChatColor.RED}構文エラーです。")
        }

        return true
    }
}