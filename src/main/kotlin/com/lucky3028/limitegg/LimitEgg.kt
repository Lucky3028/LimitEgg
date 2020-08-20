package com.lucky3028.limitegg

import org.bukkit.plugin.java.JavaPlugin

class LimitEgg : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        // Playerが卵またはスポーンエッグを右クリックで使ったとき、それが自分がOwnerであるかMemberである保護であれば実行する。
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}