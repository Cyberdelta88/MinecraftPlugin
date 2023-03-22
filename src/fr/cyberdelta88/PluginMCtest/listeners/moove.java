package fr.cyberdelta88.PluginMCtest.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class moove implements Listener {
    @EventHandler
    void onPlayerMoove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (!p.hasPermission("PluginMc_V1.op_perms")) {
            e.setCancelled(true);
        }
    }

}
