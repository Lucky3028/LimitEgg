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
        val wg = WorldGuardPlugin.inst()!!

        // pLayerが今立っている場所の保護を取得
        val regions = wg.getRegionManager(player.world).getApplicableRegions(player.location).regions

        for (rg in regions) {
            // 1つでもOwnerまたはMemberである保護があるなら処理を終了（イベントはキャンセルされない）
            // （isMemberは指定したLocalPlayerがその保護のMemberであるかだけでなくOwnerであるかどうかも調べてくれる）
            if (rg.isMember(wg.wrapPlayer(player))) return
        }

        // まとめ：今いる座標に保護がないか、自分がOwnerでもMemberでもない保護が1つでもあればイベントをキャンセルする
        e.isCancelled = true
    }
}
