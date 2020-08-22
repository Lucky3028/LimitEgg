package com.github.lucky3028.limitegg

import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.configuration.file.FileConfiguration

object ConfigHandler {
    private var config: FileConfiguration? = null
    private val plugin = LimitEgg.instance!!

    fun saveDefConfig() {
        saveDefaultConfig()
    }

    fun loadConfig() {
        config = getConfig()
    }

    fun reloadConfig() {
        plugin.reloadConfig()
        config = getConfig()
    }

    fun saveConfig() {
        plugin.saveConfig()
    }

    //config.ymlがない時にデフォルトのymlを生成
    private fun saveDefaultConfig() {
        plugin.saveDefaultConfig()
    }

    //config.ymlを読み込む
    private fun getConfig(): FileConfiguration? {
        return plugin.getConfig()
    }

    /**
     * LimitEggが無効化されているワールドなのかどうか
     * @param world 確認する対象のワールド
     * @return 無効化されているならtrue、有効化されているならfalse。デフォルトはfalse。
     */
    fun isLimitEggDisabled(world: World) : Boolean {
        return config?.getStringList("LimitEggDisabledWorld")?.contains(world.name) ?: false
    }
}
