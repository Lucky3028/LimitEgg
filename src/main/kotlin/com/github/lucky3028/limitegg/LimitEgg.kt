package com.github.lucky3028.limitegg

import com.github.lucky3028.limitegg.ConfigHandler.loadConfig
import com.github.lucky3028.limitegg.ConfigHandler.saveDefConfig
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class LimitEgg : JavaPlugin() {
    companion object {
        var instance: LimitEgg? = null
            private set
    }

    override fun onEnable() {
        instance = this

        Bukkit.getPluginManager().registerEvents(PlayerClickListener, this)

        saveDefConfig()
        loadConfig()
    }
}