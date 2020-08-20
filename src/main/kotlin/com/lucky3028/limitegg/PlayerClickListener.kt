package com.lucky3028.limitegg

import com.sk89q.worldguard.bukkit.WorldGuardPlugin
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

object PlayerClickListener : Listener {
    @EventHandler
    fun onEggClicked(e: PlayerInteractEvent) {
        val player = e.player

        if (player.inventory.itemInMainHand.type != Material.EGG
                && player.inventory.itemInMainHand.type != Material.MONSTER_EGG) return

        // dependをplugin.ymlで指定してあるので、WGのインスタンスはnullにならない（はず）
        val wg = WorldGuardPlugin.inst()

        // pLayerが今立っている場所の保護を取得
        val regions = wg.getRegionManager(player.world).getApplicableRegions(player.location).getRegions()
        // 保護がなければ終了
        if (regions.size < 1) return

        for (rg in regions) {
            // TODO この実装だと、OwnerかMemberである保護とそうではない保護が重なっていたときに後者が先に判定された場合に困る
            // OwnerかMemberではないならイベントをキャンセルしその場で終了
            // （isMemberは指定したLocalPlayerがその保護のMemberであるかだけでなくOwnerであるかどうかも調べてくれる）
            if (!rg.isMember(wg.wrapPlayer(player))){
                e.isCancelled = true
                return
            }
        }
    }
}
