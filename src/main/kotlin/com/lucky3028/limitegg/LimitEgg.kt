package com.lucky3028.limitegg

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class LimitEgg : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(PlayerClickListener, this)
    }
}