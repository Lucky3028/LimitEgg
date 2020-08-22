package com.github.lucky3028.limitegg

import org.bukkit.ChatColor
import org.bukkit.entity.Player

object IgnoreFlag {
    private val ignoreFlagMap: MutableMap<Player, Boolean> = HashMap()

    fun readIgnoreFlagState(player: Player) = ignoreFlagMap[player] ?: false

    fun toggleIgnoreFlag(player: Player) {
        val current = readIgnoreFlagState(player)
        val new = !current

        ignoreFlagMap[player] = new

        if (new) {
            player.sendMessage("${ChatColor.RED}LimitEggの制限を解除しました。")
        } else {
            player.sendMessage("${ChatColor.GREEN}LimitEggの制限を設定しました。")
        }
    }
}