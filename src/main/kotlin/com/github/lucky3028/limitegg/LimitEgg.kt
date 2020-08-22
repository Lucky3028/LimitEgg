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

    private val ignoreFlag = IgnoreFlag()
    private val ignoreFlagManager = ToggleCommand(ignoreFlag)

    override fun onEnable() {
        instance = this

        getCommand("limitegg").executor = ignoreFlagManager

        Bukkit.getPluginManager().registerEvents(PlayerClickListener, this)

        saveDefConfig()
        loadConfig()
    }
}