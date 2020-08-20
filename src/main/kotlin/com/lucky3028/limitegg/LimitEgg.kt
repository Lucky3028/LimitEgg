package com.lucky3028.limitegg

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class LimitEgg : JavaPlugin() {
    companion object {
        var instance: LimitEgg? = null
            private set
    }

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(PlayerClickListener, this)
        instance = this
        // Plugin startup logic
        // Playerが卵またはスポーンエッグを右クリックで使ったとき、それが自分がOwnerであるかMemberである保護であれば実行する。
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}