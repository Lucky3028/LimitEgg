package com.lucky3028.limitegg

import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.configuration.file.FileConfiguration

object Config {
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
     * LimitEggが有効化されているワールドなのかどうか
     * @param world 確認する対象のワールド
     * @return 有効化されているならtrue、無効化されているならfalse。デフォルトは有効化（true）。
     */
    fun isLimitEggEnabled(world: World) : Boolean {
        // config.ymlに記入されているのは「無効化されるワールド」の指定であることに注意
        val ans = config?.getStringList("LimitEggDisabledWorld")?.contains(world.name) ?: false
        return !ans
    }
}
